package com.callRing.common.mapper;

import com.callRing.common.po.UserIntersetRelation;

public interface UserIntersetRelationDao {
    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(UserIntersetRelation record);

    /**
     *
     * @param record
     */
    int insertSelective(UserIntersetRelation record);
}