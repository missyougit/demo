package com.yangqiang.tuku.model;

public class UserAction {

    private int id;
    private String openId;        //操作人
    private int imagesId;         //
    private String targetOpenId;  //操作人回复targetOpenId的评论
    private int thumbsUp;         //动作类型  0.未喜欢  1.喜欢
    private int fenXiang;         //动作类型  0.未分享  1.分享
    private int pingLun;          //动作类型  0.未评论  1.评论
    private String content;       //评论内容

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

    public String getTargetOpenId() {
        return targetOpenId;
    }

    public void setTargetOpenId(String targetOpenId) {
        this.targetOpenId = targetOpenId;
    }

    public int getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(int thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public int getFenXiang() {
        return fenXiang;
    }

    public void setFenXiang(int fenXiang) {
        this.fenXiang = fenXiang;
    }

    public int getPingLun() {
        return pingLun;
    }

    public void setPingLun(int pingLun) {
        this.pingLun = pingLun;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
