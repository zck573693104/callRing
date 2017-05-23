package com.callRing.common.mapper;

import com.callRing.common.po.Interset;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IntersetDao {
    int save(Interset record);

    int saveSelective(Interset record);

    void batchSave(List<Interset> intersetList);

    List<String>getHotWord(@Param("firTime")Date firTime,@Param("name")String name);
}