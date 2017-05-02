package com.callRing.task;

import com.callRing.common.po.Interset;
import com.callRing.common.service.IntersetService;
import com.callRing.friend.po.Message;
import com.callRing.friend.service.MessageService;
import com.callRing.spark.WordCount;
import com.huaban.analysis.jieba.JiebaSegmenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.*;

/**
 * Created by kcz on 2017/4/15.
 */
@Service
public class Job implements Serializable {

	private static final String splitString = "@";
	private static final long serialVersionUID = -4099092846577558755L;

	@Autowired
	private MessageService messageService;

	@Autowired
	private JiebaSegmenter jiebaSegmenter;

	@Autowired
	private WordCount wordCount;

	@Autowired
	private IntersetService intersetService;

	public Map<String, Map> getContext() throws Exception {
		Map<String, List<String>> stringListMap = new HashMap<>();
		List<Map<String, List<String>>> sentenceList = new ArrayList<>();
		Map<String, Map> mapMap = new TreeMap<>();
		Map<String, StringBuilder> intersetMap = new HashMap<>();
		Date beginDate = new Date();
		beginDate.setHours(00);
		beginDate.setMinutes(00);
		List<Message> mapList = messageService.getMessage(beginDate, new Date());
		if (!CollectionUtils.isEmpty(mapList)) {
			// 将所有key相同的分为一组
			byKey(intersetMap, mapList);
			if (!CollectionUtils.isEmpty(intersetMap)) {
				// 按照key将里面的内容进行分词
				byJieBa(stringListMap, intersetMap);
				sentenceList.add(stringListMap);
			}
			// 统计每个词语出现的频率
			byWordCount(sentenceList, mapMap);
			// 进行排序
			Map<String, List<Map.Entry<String, Integer>>> listMap = getHotEveryDay(mapMap);
			saveHotEveryDay(listMap);
		}
		return mapMap;
	}

	private void saveHotEveryDay(Map<String, List<Map.Entry<String, Integer>>> listMap) {
		List<Interset> intersetList = new ArrayList<>();
		for (Map.Entry<String, List<Map.Entry<String, Integer>>> entry : listMap.entrySet()) {
			Interset interset = new Interset();
			StringBuilder stringBuilder = new StringBuilder();
			for (Map.Entry<String, Integer> entry1 : entry.getValue()) {
				stringBuilder.append(entry1.getKey() + ":" + entry1.getValue() + splitString);
			}
			setBean(interset,entry.getKey(),stringBuilder.toString());
			intersetList.add(interset);
		}
		intersetService.batchSave(intersetList);
	}

	public void setBean(Interset interset,String key,String hotContext){
		interset.setId(UUID.randomUUID().toString());
		interset.setName(key);
		interset.setHotWord(hotContext);
		Date date = new Date();
		interset.setLastUpTime(date);
		interset.setFirTime(date);
	}
	public static int countStrLength(String str1, String str2) {
		int counter = 0;
		if (str1.indexOf(str2) == -1) {
			return 0;
		} else if (str1.indexOf(str2) != -1) {
			counter++;
			countStrLength(str1.substring(str1.indexOf(str2) + str2.length()), str2);
			return counter;
		}
		return 0;
	}

	private void byWordCount(List<Map<String, List<String>>> sentenceList, Map<String, Map> mapMap) {
		for (Map<String, List<String>> wordList : sentenceList) {
			for (Map.Entry<String, List<String>> entry : wordList.entrySet()) {
				mapMap.put(entry.getKey(), wordCount.wordCount(entry.getValue()));

			}

		}
	}

	private void byKey(Map<String, StringBuilder> intersetMap, List<Message> mapList) {
		for (Message message : mapList) {
			String key = message.getUserName() + splitString + message.getFriendName();
			StringBuilder value = new StringBuilder(message.getText());
			if (intersetMap.containsKey(key)) {
				intersetMap.get(key).append(",").append(value);
			} else {
				intersetMap.put(key, value);
			}

		}
	}

	private void byJieBa(Map<String, List<String>> stringListMap, Map<String, StringBuilder> intersetMap) {
		for (Map.Entry<String, StringBuilder> entry : intersetMap.entrySet()) {

			if (intersetMap.containsKey(entry.getKey()))
				if (stringListMap.containsKey(entry.getKey())) {
					stringListMap.get(entry.getKey())
							.addAll(jiebaSegmenter.sentenceProcess(entry.getValue().toString()));
				} else {
					stringListMap.put(entry.getKey(), jiebaSegmenter.sentenceProcess(entry.getValue().toString()));
				}
		}
	}

	/**
	 * Map提供了一些常用方法，如keySet()、entrySet()等方法， keySet()方法返回值是Map中key值的集合；entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
	 * 
	 * Map.Entry是Map声明的一个内部接口，此接口为泛型， 定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。
	 * 
	 * @param wordCountListMap
	 * @return
	 */

	public Map<String, List<Map.Entry<String, Integer>>> getHotEveryDay(Map<String, Map> wordCountListMap) {
		Map<String, List<Map.Entry<String, Integer>>> mapList = new LinkedHashMap<>();
		for (Map.Entry<String, Map> entry : wordCountListMap.entrySet()) {

			List<Map.Entry<String, Integer>> list_Data = new ArrayList<Map.Entry<String, Integer>>(
					entry.getValue().entrySet());
			Collections.sort(list_Data, new Comparator<Map.Entry<String, Integer>>() {
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

					return o2.getValue().compareTo(o1.getValue());

				}
			});
			mapList.put(entry.getKey(), list_Data);
		}

		return mapList;
	}

}
