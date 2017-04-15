package com.commmon.po;

import java.io.Serializable;

public class UserIntersetRelation implements Serializable{

    private static final long serialVersionUID = -8694068444388752247L;
    /**
     * <pre>
     * 用户id
     * 表字段 : user_interset_relation.user_id
     * </pre>
     */
    private String userId;

    /**
     * <pre>
     * 话题id
     * 表字段 : user_interset_relation.interset_id
     * </pre>
     */
    private String intersetId;

    /**
     * <pre>
     * 话题聊天内容
     * 表字段 : user_interset_relation.context
     * </pre>
     */
    private String context;

    /**
     * <pre>
     * 获取：用户id
     * 表字段：user_interset_relation.user_id
     * </pre>
     *
     * @return user_interset_relation.user_id：用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * <pre>
     * 设置：用户id
     * 表字段：user_interset_relation.user_id
     * </pre>
     *
     * @param userId
     *            user_interset_relation.user_id：用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * <pre>
     * 获取：话题id
     * 表字段：user_interset_relation.interset_id
     * </pre>
     *
     * @return user_interset_relation.interset_id：话题id
     */
    public String getIntersetId() {
        return intersetId;
    }

    /**
     * <pre>
     * 设置：话题id
     * 表字段：user_interset_relation.interset_id
     * </pre>
     *
     * @param intersetId
     *            user_interset_relation.interset_id：话题id
     */
    public void setIntersetId(String intersetId) {
        this.intersetId = intersetId;
    }

    /**
     * <pre>
     * 获取：话题聊天内容
     * 表字段：user_interset_relation.context
     * </pre>
     *
     * @return user_interset_relation.context：话题聊天内容
     */
    public String getContext() {
        return context;
    }

    /**
     * <pre>
     * 设置：话题聊天内容
     * 表字段：user_interset_relation.context
     * </pre>
     *
     * @param context
     *            user_interset_relation.context：话题聊天内容
     */
    public void setContext(String context) {
        this.context = context;
    }
}