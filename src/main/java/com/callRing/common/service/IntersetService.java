package com.callRing.common.service;

import com.callRing.common.po.Interset;

import java.util.List;

/**
 * Created by kcz on 2017/4/23.
 */
public interface IntersetService {

    int insert(Interset record);

    void batchSave(List<Interset> intersetList);
}
