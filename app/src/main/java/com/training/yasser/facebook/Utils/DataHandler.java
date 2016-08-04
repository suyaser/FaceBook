package com.training.yasser.facebook.Utils;

import com.training.yasser.facebook.Data.Post;

import java.util.List;

/**
 * Created by yasser on 04/08/2016.
 */
public abstract class DataHandler {
    public abstract List<Post> handleData(String data);
}
