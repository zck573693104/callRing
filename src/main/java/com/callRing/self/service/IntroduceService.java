package com.callRing.self.service;

import com.callRing.self.po.Introduce;
import com.callRing.self.po.User;

/**
 * Created by kcz on 2016/5/20.
 */

public interface IntroduceService {

    Introduce queryIntroduce(User user)throws Exception;

    void updateIntroduce(Introduce introduce)throws Exception;

    void insertIntroduce(Introduce introduce)throws Exception;

    Boolean updateOrInsertIntroduce(User user)throws Exception;
}
