package com.friend.po;

import java.io.Serializable;

public class Friend implements Serializable {

	private static final long serialVersionUID = 3154080041875895341L;

	public String count;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String friendgraphTheoryImagePicPath;
	
	
	public String getFriendgraphTheoryImagePicPath() {
		return friendgraphTheoryImagePicPath;
	}
	public void setFriendgraphTheoryImagePicPath(
			String friendgraphTheoryImagePicPath) {
		this.friendgraphTheoryImagePicPath = friendgraphTheoryImagePicPath;
	}
	public String friendName;

	public String getFriendIntroduceTittle() {
		return friendIntroduceTittle;
	}

	public void setFriendIntroduceTittle(String friendIntroduceTittle) {
		this.friendIntroduceTittle = friendIntroduceTittle;
	}

	public String friendIntroduceTittle;
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

}
