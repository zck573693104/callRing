package com.self.service.serviceImpl;

import com.self.mapper.GraphTheoryMapper;
import com.self.po.GraphTheory;
import com.self.service.GraphTheoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kcz on 2016/5/22.
 */
@Service
@Transactional
public class GraphTheoryServiceImpl implements GraphTheoryService {

    @Autowired
    private GraphTheoryMapper graphTheoryMapper;
  
    public void insertPicPath(List<GraphTheory> graphTheoryList) throws Exception {
       graphTheoryMapper.insertPicPath(graphTheoryList);
    }

  
    public List<GraphTheory> queryGraphs(GraphTheory graphTheory) throws Exception {
        return graphTheoryMapper.queryGraphs(graphTheory);
    }
}
