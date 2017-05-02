package com.callRing.common.po;

import java.io.Serializable;
import java.util.Date;

public class Interset implements Serializable {
    private static final long serialVersionUID = -943212003779169791L;
    private String id;

    /** 话题名字 **/
    private String name;

    /** 热词1 **/
    private String hotWord;

    /** 创建时间 **/
    private Date firTime;

    private Date lastUpTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotWord() {
        return hotWord;
    }

    public void setHotWord(String hotWord) {
        this.hotWord = hotWord;
    }

    public Date getFirTime() {
        return firTime;
    }

    public void setFirTime(Date firTime) {
        this.firTime = firTime;
    }

    public Date getLastUpTime() {
        return lastUpTime;
    }

    public void setLastUpTime(Date lastUpTime) {
        this.lastUpTime = lastUpTime;
    }
}