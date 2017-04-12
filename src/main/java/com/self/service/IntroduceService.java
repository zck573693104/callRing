package com.self.service;

import com.self.po.Introduce;
import com.self.po.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kcz on 2016/5/20.
 */

public interface IntroduceService {

    Introduce queryIntroduce(User user)throws Exception;

    void updateIntroduce(Introduce introduce)throws Exception;

    void insertIntroduce(Introduce introduce)throws Exception;

    Boolean updateOrInsertIntroduce(User user)throws Exception;
}
