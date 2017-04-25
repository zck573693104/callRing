package com.callRing.common.mapper;

import com.callRing.common.po.UserIntersetRelation;

public interface UserIntersetRelationDao {
    int save(UserIntersetRelation record);

    int saveSelective(UserIntersetRelation record);
}