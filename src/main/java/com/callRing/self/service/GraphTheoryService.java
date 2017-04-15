package com.callRing.self.service;

import com.callRing.self.po.GraphTheory;

import java.util.List;

/**
 * Created by kcz on 2016/5/22.
 */

public interface GraphTheoryService {

    void insertPicPath(List<GraphTheory> graphTheoryList)throws Exception;

    List<GraphTheory> queryGraphs(GraphTheory graphTheory)throws Exception;
}
