package com.yangqiang.tuku.model;

public class User {

    private int id;
    private String openId;
    private String nickName;
    private String avatarUrl;
    private int gender;
    private String regdate;
    private String code;

    //下面数据无用，只是为了方便接收前端收据
    private String country;
    private String province;
    private String city;
    private String language;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public User(String openId, String nickName, String avatarUrl, int gender, String regdate) {
        this.openId = openId;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.gender = gender;
        this.regdate = regdate;
    }

    public User() {
    }
}
