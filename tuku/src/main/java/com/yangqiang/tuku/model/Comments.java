package com.yangqiang.tuku.model;

public class Comments {

    private int id;                 // 评论id，自增
    private String openId;          // 评论人openId
    private int imagesId;           // 评论的是哪条图片
    private int targetCommentsId;   // 被回复评论id
    private String content;         // 评论/回复内容
    private int type;               // 评论类型 0 评论 ，1 回复
    private String createTime;      // 评论时间  yyyy-MM-dd HH:mm

    public Comments(String openId, int imagesId, int targetCommentsId, String content, int type, String createTime) {
        this.openId = openId;
        this.imagesId = imagesId;
        this.targetCommentsId = targetCommentsId;
        this.content = content;
        this.type = type;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", imagesId=" + imagesId +
                ", targetCommentsId=" + targetCommentsId +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public Comments() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getImagesId() {
        return imagesId;
    }

    public void setImagesId(int imagesId) {
        this.imagesId = imagesId;
    }

    public int getTargetCommentsId() {
        return targetCommentsId;
    }

    public void setTargetCommentsId(int targetCommentsId) {
        this.targetCommentsId = targetCommentsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
