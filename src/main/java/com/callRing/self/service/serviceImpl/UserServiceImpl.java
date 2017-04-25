package com.callRing.self.service.serviceImpl;

import com.callRing.exception.CustomException;
import com.callRing.self.mapper.UserMapper;
import com.callRing.self.po.User;
import com.callRing.self.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kcz on 2016/11/14.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 用户登录检查
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public User checkLogin(User user) throws Exception {
		if (userMapper.checkLogin(user)!=null){
			return userMapper.checkLogin(user);
		}
		else {
			throw new CustomException("用户名或者密码错误");
		}
	}

	/**
	 * 用户注册 先调用检查注册
	 * @param user
	 * @throws Exception
	 */
	@Override
	public void registerUser(User user) throws Exception {
		userMapper.registerUser(user);

	}

	/**
	 * 先进行检查注册功能 再注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public void checkRegister(User user) throws Exception {
		if (userMapper.checkRegister(user)!=null){
			throw new CustomException("用户名已被注册");
		}
		else {
			registerUser(user);
		}

	}

	@Override
	public void updatePicPath(User user) throws Exception {
		userMapper.updatePicPath(user);
		
	}

	@Override
	public User queryPicPath(User user) throws Exception {
		return userMapper.queryPicPath(user);
	}



	@Override
	public User queryUserInfo(User user) {
		return userMapper.queryUserInfo(user);
	}

	@Override
	public void updateUserInfo(User user) {
		userMapper.updateUserInfo(user);
	}
}
