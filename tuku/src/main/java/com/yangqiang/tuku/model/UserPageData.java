package com.yangqiang.tuku.model;

public class UserPageData {

    private User user;
    private UserActionCount userActionCount;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserActionCount getUserActionCount() {
        return userActionCount;
    }

    public void setUserActionCount(UserActionCount userActionCount) {
        this.userActionCount = userActionCount;
    }

    public UserPageData(User user, UserActionCount userActionCount) {
        this.user = user;
        this.userActionCount = userActionCount;
    }

    public UserPageData() {
    }
}
