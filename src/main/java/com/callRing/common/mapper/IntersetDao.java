package com.callRing.common.mapper;

import com.callRing.common.po.Interset;

import java.util.List;

public interface IntersetDao {
    int save(Interset record);

    int saveSelective(Interset record);

    void batchSave(List<Interset> intersetList);

    List<String>getHotWord(String name);
}