package com.callRing.self.service;

import com.callRing.self.po.User;

/**
 * Created by kcz on 2016/11/14.
 */

public interface UserService {

	User checkLogin(User user)throws Exception;

	void registerUser(User user)throws Exception;

	void checkRegister(User user)throws Exception;

	void updatePicPath(User user)throws Exception;

	User queryPicPath(User user)throws Exception;

	User queryUserInfo(User user)throws Exception;

	void updateUserInfo(User user)throws Exception;
}
