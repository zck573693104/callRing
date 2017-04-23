package com.callRing.common.mapper;

import com.callRing.common.po.Interset;

public interface IntersetDao {
    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(Interset record);

    /**
     *
     * @param record
     */
    int insertSelective(Interset record);
}