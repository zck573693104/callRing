package com.self.service;

import com.self.po.ContactWay;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kcz on 2016/5/30.
 */

public interface ContactWayService {

    void insertContactWay(ContactWay contactWay)throws Exception;
}
