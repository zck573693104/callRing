package com.callRing.common.service;

import com.callRing.common.po.UserIntersetRelation;

/**
 * Created by kcz on 2017/4/23.
 */
public interface UserIntersetRelationService {

    int insert(UserIntersetRelation record);

    int insertSelective(UserIntersetRelation record);
}
