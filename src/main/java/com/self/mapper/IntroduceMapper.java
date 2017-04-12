package com.self.mapper;

import com.self.po.Introduce;
import com.self.po.User;

/**
 * Created by kcz on 2016/5/20.
 */
public interface IntroduceMapper {

   Introduce queryIntroduce(User user);

    void updateIntroduce(Introduce introduce);

    void insertIntroduce(Introduce introduce);

    Introduce updateOrInsertIntroduce(User user);
}
