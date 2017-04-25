package com.callRing.common.mapper;

import com.callRing.common.po.Interset;

public interface IntersetDao {
    int save(Interset record);

    int saveSelective(Interset record);
}