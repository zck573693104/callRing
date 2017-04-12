package com.friend.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kcz on 2017/2/4.
 */
public class SpanVo implements Serializable{

    private static final long serialVersionUID = -5457045237665271731L;

    private String friendName;

    private String logDayContext;

    private String userHeadPortraitPath;

    private Date logDate;

    private int id;

    private String logDateString;

    public String getLogDateString() {
        return logDateString;
    }

    public void setLogDateString(String logDateString) {
        this.logDateString = logDateString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getLogDayContext() {
        return logDayContext;
    }

    public void setLogDayContext(String logDayContext) {
        this.logDayContext = logDayContext;
    }

    public String getUserHeadPortraitPath() {
        return userHeadPortraitPath;
    }

    public void setUserHeadPortraitPath(String userHeadPortraitPath) {
        this.userHeadPortraitPath = userHeadPortraitPath;
    }
}
