package com.self.service;

import com.self.po.GraphTheory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kcz on 2016/5/22.
 */

public interface GraphTheoryService {

    void insertPicPath(List<GraphTheory> graphTheoryList)throws Exception;

    List<GraphTheory> queryGraphs(GraphTheory graphTheory)throws Exception;
}
