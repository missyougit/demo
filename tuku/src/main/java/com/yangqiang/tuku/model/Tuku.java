package com.yangqiang.tuku.model;

import java.util.List;

public class Tuku {

    private int id;
    private String title;
    private List<String> imagesList;
    private String images;
    private String createTime;
    private UserActionCount userActionCount;
    private boolean myThumbsUp;

    public boolean isMyThumbsUp() {
        return myThumbsUp;
    }

    public void setMyThumbsUp(boolean myThumbsUp) {
        this.myThumbsUp = myThumbsUp;
    }

    public UserActionCount getUserActionCount() {
        return userActionCount;
    }

    public void setUserActionCount(UserActionCount userActionCount) {
        this.userActionCount = userActionCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<String> imagesList) {
        this.imagesList = imagesList;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "Tuku{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imagesList=" + imagesList +
                ", images='" + images + '\'' +
                ", createTime='" + createTime + '\'' +
                ", userActionCount=" + userActionCount +
                ", myThumbsUp=" + myThumbsUp +
                '}';
    }
}
