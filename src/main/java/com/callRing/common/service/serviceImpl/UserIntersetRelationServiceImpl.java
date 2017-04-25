package com.callRing.common.service.serviceImpl;

import com.callRing.common.mapper.UserIntersetRelationDao;
import com.callRing.common.po.UserIntersetRelation;
import com.callRing.common.service.UserIntersetRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kcz on 2017/4/23.
 */
@Service
@Transactional
public class UserIntersetRelationServiceImpl implements UserIntersetRelationService {

    @Autowired
    private UserIntersetRelationDao userIntersetRelationDao;

    @Override
    public int insert(UserIntersetRelation record) {
        return userIntersetRelationDao.save(record);
    }

    @Override
    public int insertSelective(UserIntersetRelation record) {
        return userIntersetRelationDao.saveSelective(record);
    }
}
