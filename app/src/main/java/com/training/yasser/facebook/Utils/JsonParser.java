package com.training.yasser.facebook.Utils;

import com.training.yasser.facebook.Data.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yasser on 04/08/2016.
 */
public class JsonParser extends DataHandler{
    @Override
    public List<Post> handleData(String jsonResponse) {

        List<Post> posts = new ArrayList<Post>();
        try {
            JSONArray base = new JSONArray(jsonResponse);
            JSONObject post;
            for(int i = 0; i < base.length(); i++){
                post = base.getJSONObject(i);
                String comments = post.getString("comments");
                String likes = post.getString("likes");
                String postImg = post.getString("postImage");
                String postText = post.getString("postText");
                String postTime = post.getString("postTime");
                String shares = post.getString("shares");
                String userName = post.getString("userName");
                String userPic = post.getString("userPic");
                posts.add(new Post(comments,likes,postImg,postText,postTime,shares,userName,userPic));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return posts;
    }
}

