package com.callRing.self.service.serviceImpl;

import com.callRing.self.mapper.ContactWayMapper;
import com.callRing.self.po.ContactWay;
import com.callRing.self.service.ContactWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kcz on 2016/5/30.
 */
@Service
@Transactional
public class ContactWayServiceImpl implements ContactWayService {

    @Autowired
    private ContactWayMapper contactWayMapper;
    
    public void insertContactWay(ContactWay contactWay) throws Exception {
        contactWayMapper.insertContactWay(contactWay);
    }
}
