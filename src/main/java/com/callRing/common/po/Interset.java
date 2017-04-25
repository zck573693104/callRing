package com.callRing.common.po;

import java.io.Serializable;
import java.util.Date;

public class Interset implements Serializable {
    private static final long serialVersionUID = -76281624203127386L;
    private String id;

    /** 话题名字 **/
    private String name;

    /** 发布内容 **/
    private String context;

    /** 话题描述 **/
    private String description;

    /** 热词1 **/
    private String hotWord1;

    private String hotWord2;

    private String hotWord3;

    private String hotWord4;

    private String hotWord5;

    private String hotWord6;

    private String hotWord7;

    private String hotWord8;

    private String hotWord9;

    private String hotWord10;

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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHotWord1() {
        return hotWord1;
    }

    public void setHotWord1(String hotWord1) {
        this.hotWord1 = hotWord1;
    }

    public String getHotWord2() {
        return hotWord2;
    }

    public void setHotWord2(String hotWord2) {
        this.hotWord2 = hotWord2;
    }

    public String getHotWord3() {
        return hotWord3;
    }

    public void setHotWord3(String hotWord3) {
        this.hotWord3 = hotWord3;
    }

    public String getHotWord4() {
        return hotWord4;
    }

    public void setHotWord4(String hotWord4) {
        this.hotWord4 = hotWord4;
    }

    public String getHotWord5() {
        return hotWord5;
    }

    public void setHotWord5(String hotWord5) {
        this.hotWord5 = hotWord5;
    }

    public String getHotWord6() {
        return hotWord6;
    }

    public void setHotWord6(String hotWord6) {
        this.hotWord6 = hotWord6;
    }

    public String getHotWord7() {
        return hotWord7;
    }

    public void setHotWord7(String hotWord7) {
        this.hotWord7 = hotWord7;
    }

    public String getHotWord8() {
        return hotWord8;
    }

    public void setHotWord8(String hotWord8) {
        this.hotWord8 = hotWord8;
    }

    public String getHotWord9() {
        return hotWord9;
    }

    public void setHotWord9(String hotWord9) {
        this.hotWord9 = hotWord9;
    }

    public String getHotWord10() {
        return hotWord10;
    }

    public void setHotWord10(String hotWord10) {
        this.hotWord10 = hotWord10;
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