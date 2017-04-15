package com.callRing.self.po;

import java.io.Serializable;

/**
 * Created by kcz on 2016/5/20.
 */
public class Introduce implements Serializable {
	private static final long serialVersionUID = -4933100094460887629L;
	private String introduceTittle;
    private String userName;
    
    private String introduceContent;

   

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

	public String getIntroduceTittle() {
		return introduceTittle;
	}

	public void setIntroduceTittle(String introduceTittle) {
		this.introduceTittle = introduceTittle;
	}

	public String getIntroduceContent() {
		return introduceContent;
	}

	public void setIntroduceContent(String introduceContent) {
		this.introduceContent = introduceContent;
	}

   
}
