package com.callRing.self.mapper;

import com.callRing.self.po.GraphTheory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kcz on 2016/5/22.
 */
public interface GraphTheoryMapper{

    void insertPicPath(@Param("graphTheoryList") List<GraphTheory> graphTheoryList)throws Exception;

    List<GraphTheory> queryGraphs(GraphTheory graphTheory)throws Exception;
}
