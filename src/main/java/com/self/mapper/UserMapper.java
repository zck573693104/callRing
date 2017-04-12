package com.self.mapper;


import com.self.po.User;


/**
 * Created by kcz on 2016/11/14.
 */
public interface UserMapper {

	User checkLogin(User user);

	void registerUser(User user);

	User  checkRegister(User user);

	void updatePicPath(User user)
			;
	User queryPicPath(User user);

	void updateUserInfo(User user);

    User queryUserInfo(User user);
}
