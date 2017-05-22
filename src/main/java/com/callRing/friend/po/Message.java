package com.callRing.friend.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable {

	private static final long serialVersionUID = 3337510564677463088L;
	//离线消息为TRUE 读了之后update为false
	public boolean read;
	private String userHeadPortraitPath;

	public String getUserHeadPortraitPath() {
		return userHeadPortraitPath;
	}

	public void setUserHeadPortraitPath(String userHeadPortraitPath) {
		this.userHeadPortraitPath = userHeadPortraitPath;
	}

	public Timestamp sendTimestamp;

	public String count;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Timestamp getSendTimestamp() {
		return sendTimestamp;
	}

	public void setSendTimestamp(Timestamp sendTimestamp) {
		this.sendTimestamp = sendTimestamp;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public Long from;

	/**
	 * @return the from
	 */
	public Long getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(Long from) {
		this.from = from;
	}

	public String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String friendName;






	//发送的文本
	public String text;

	public Timestamp getSendDate() {
		return sendDate;
	}

	public void setSendDate(Timestamp sendDate) {
		this.sendDate = sendDate;
	}

	//发送日期
	public Timestamp sendDate;

    public String sendDaetString;

	public String getSendDaetString() {
		return sendDaetString;
	}

	public void setSendDaetString(String sendDaetString) {
		this.sendDaetString = sendDaetString;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}







}
