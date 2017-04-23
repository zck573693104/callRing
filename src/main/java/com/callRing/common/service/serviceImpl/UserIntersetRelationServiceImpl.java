package com.callRing.common.service.serviceImpl;

import com.callRing.common.mapper.UserIntersetRelationDao;
import com.callRing.common.po.UserIntersetRelation;
import com.callRing.common.service.UserIntersetRelationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kcz on 2017/4/23.
 */
public class UserIntersetRelationServiceImpl implements UserIntersetRelationService {

    @Autowired
    private UserIntersetRelationDao userIntersetRelationDao;

    @Override
    public int insert(UserIntersetRelation record) {
        return userIntersetRelationDao.insert(record);
    }

    @Override
    public int insertSelective(UserIntersetRelation record) {
        return userIntersetRelationDao.insertSelective(record);
    }
}
