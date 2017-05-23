package com.callRing.common.service.serviceImpl;

import com.callRing.common.mapper.IntersetDao;
import com.callRing.common.po.Interset;
import com.callRing.common.service.IntersetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kcz on 2017/4/23.
 */
@Service
public class IntersetServiceImpl implements IntersetService {
	private static final String split = "@";

	@Autowired
	private IntersetDao intersetDao;

	@Override
	public int insert(Interset record) {
		return intersetDao.save(record);
	}

	@Override
	public void batchSave(List<Interset> intersetList) {
		intersetDao.batchSave(intersetList);
	}

	@Override
	public List<String> getHotWord(String name) throws ParseException {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<String> hotWordList = intersetDao.getHotWord(sdf.parse(sdf.format(new Date())),name);
		List<String> valueList = new ArrayList<>();
		for (String hotWord : hotWordList) {
			String[] deal = hotWord.substring(0, hotWord.lastIndexOf(split)).split(split);
			// 舍弃一个字
			for (String dealString : deal) {
				if (dealString.length() > 4&& !dealString.contains(",")) {
					valueList.add(dealString);
				}
			}

		}
		return valueList;
	}

}
