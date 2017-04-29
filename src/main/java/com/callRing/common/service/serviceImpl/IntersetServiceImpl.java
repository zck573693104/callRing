package com.callRing.common.service.serviceImpl;

import com.callRing.common.mapper.IntersetDao;
import com.callRing.common.po.Interset;
import com.callRing.common.service.IntersetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kcz on 2017/4/23.
 */
@Service
public class IntersetServiceImpl implements IntersetService {

    @Autowired
    private IntersetDao intersetDao;

    @Override
    public int insert(Interset record) {
        return intersetDao.save(record);
    }

    @Override
    public int insertSelective(Interset record) {
        return intersetDao.saveSelective(record);
    }
}
