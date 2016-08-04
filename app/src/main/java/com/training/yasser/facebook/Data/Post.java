package com.training.yasser.facebook.Data;

/**
 * Created by yasser on 28/07/2016.
 */
public class Post {

    private String mComments;
    private String mLikes;
    private String mPostImg;
    private String mPostTxt;
    private String mPostTime;
    private String mShares;
    private String mUserName;
    private String mUserPic;

    public Post(String mComments, String mLikes, String mPostImg, String mPostTxt, String mPostTime, String mShares, String mUserName, String mUserPic) {
        this.mComments = mComments;
        this.mLikes = mLikes;
        this.mPostImg = mPostImg;
        this.mPostTxt = mPostTxt;
        this.mPostTime = mPostTime;
        this.mShares = mShares;
        this.mUserName = mUserName;
        this.mUserPic = mUserPic;
    }

    public String getmComments() {
        return mComments;
    }

    public String getmLikes() {
        return mLikes;
    }

    public String getmPostImg() {
        return mPostImg;
    }

    public String getmPostTxt() {
        return mPostTxt;
    }

    public String getmPostTime() {
        return mPostTime;
    }

    public String getmShares() {
        return mShares;
    }

    public String getmUserName() {
        return mUserName;
    }

    public String getmUserPic() {
        return mUserPic;
    }
}
