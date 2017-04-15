package com.callRing.self.po;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 7469978706397262916L;
	private String userName;
	private String userHeadPortraitPath;
	private String userIntroduce;

	public String getUserIntroduce() {
		return userIntroduce;
	}

	public void setUserIntroduce(String userIntroduce) {
		this.userIntroduce = userIntroduce;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUserHeadPortraitPath() {
		return userHeadPortraitPath;
	}

	public void setUserHeadPortraitPath(String userHeadPortraitPath) {
		this.userHeadPortraitPath = userHeadPortraitPath;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private int userId;
	private String userPassword;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}

