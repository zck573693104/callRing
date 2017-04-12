package com.self.po;

import java.io.Serializable;

/**
 * Created by kcz on 2016/5/30.
 */
public class ContactWay implements Serializable {

    private static final long serialVersionUID = 179963956982766697L;
    public String userName;
    public String  contactWayTittle;

    /**
	 * @return the contactWayTittle
	 */
	public String getContactWayTittle() {
		return contactWayTittle;
	}

	/**
	 * @param contactWayTittle the contactWayTittle to set
	 */
	public void setContactWayTittle(String contactWayTittle) {
		this.contactWayTittle = contactWayTittle;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactWayMessage() {
        return contactWayMessage;
    }

    public void setContactWayMessage(String contactWayMessage) {
        this.contactWayMessage = contactWayMessage;
    }



   

    public String contactWayMessage;

}
