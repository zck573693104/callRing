package com.callRing.common.service.serviceImpl;

import com.callRing.common.mapper.IntersetDao;
import com.callRing.common.po.Interset;
import com.callRing.common.service.IntersetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
	public List<String> getHotWord(String name) {
		List<String> hotWordList = intersetDao.getHotWord(name);
		List<String> valueList = new ArrayList<>();
		for (String hotWord : hotWordList) {
			String[] deal = hotWord.substring(0, hotWord.lastIndexOf(split)).split(split);
			// 舍弃一个字
			for (String dealString : deal) {
				if (dealString.length() > 3) {
					valueList.add(dealString);
				}
			}

		}
		return valueList;
	}

}
