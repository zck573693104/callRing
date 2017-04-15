package com.callRing.self.mapper;

import com.callRing.self.po.Introduce;
import com.callRing.self.po.User;

/**
 * Created by kcz on 2016/5/20.
 */
public interface IntroduceMapper {

   Introduce queryIntroduce(User user);

    void updateIntroduce(Introduce introduce);

    void insertIntroduce(Introduce introduce);

    Introduce updateOrInsertIntroduce(User user);
}
