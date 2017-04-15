package com.callRing.self.po;

import java.io.Serializable;

/**
 * Created by kcz on 2016/6/4.
 */
public class LogDay implements Serializable {
    private static final long serialVersionUID = -3378417487903181212L;
    public String logDayTittle;
    public String logDate;
    public String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public String getLogDayTittle() {
        return logDayTittle;
    }

    public void setLogDayTittle(String logDayTittle) {
        this.logDayTittle = logDayTittle;
    }

    public String getLogDayContext() {
        return logDayContext;
    }

    public void setLogDayContext(String logDayContext) {
        this.logDayContext = logDayContext;
    }

    public String   logDayContext;
}
