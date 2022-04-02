package com.yangqiang.tuku.model;

public class UserAction {

    private int id;
    private String openId;        //操作人
    private int imagesId;         //
    private int thumbsUp;         //动作类型  0.未喜欢  1.喜欢
    private int fenXiang;         //动作类型  0.未分享  1.分享
    private int shouCang;         //动作类型  0.未收藏  1.收藏

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

    public int getShouCang() {
        return shouCang;
    }

    public void setShouCang(int shouCang) {
        this.shouCang = shouCang;
    }
}
