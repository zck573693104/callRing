package com.callRing.common.po;

import java.io.Serializable;

public class UserIntersetRelation implements Serializable {
    private static final long serialVersionUID = 6043990721792135791L;
    /** 用户id **/
    private String userId;

    /** 话题id **/
    private String intersetId;

    /** 话题聊天内容 **/
    private String context;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIntersetId() {
        return intersetId;
    }

    public void setIntersetId(String intersetId) {
        this.intersetId = intersetId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}