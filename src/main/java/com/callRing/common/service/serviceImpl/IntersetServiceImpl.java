package com.callRing.common.service.serviceImpl;

import com.callRing.common.mapper.IntersetDao;
import com.callRing.common.po.Interset;
import com.callRing.common.service.IntersetService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kcz on 2017/4/23.
 */
public class IntersetServiceImpl implements IntersetService {

    @Autowired
    private IntersetDao intersetDao;

    @Override
    public int insert(Interset record) {
        return intersetDao.insert(record);
    }

    @Override
    public int insertSelective(Interset record) {
        return intersetDao.insertSelective(record);
    }
}
