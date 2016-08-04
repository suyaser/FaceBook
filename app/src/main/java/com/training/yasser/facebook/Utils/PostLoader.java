package com.training.yasser.facebook.Utils;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.training.yasser.facebook.Data.Post;

import java.util.List;

/**
 * Created by yasser on 28/07/2016.
 */
public class PostLoader extends AsyncTaskLoader<List<Post>> {

    private Connection mConnection;

    public PostLoader(Context context, String requestUrl) {
        super(context);
        mConnection = new Connection(context, requestUrl);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }


    @Override
    public List<Post> loadInBackground() {
        String jsonResponse = mConnection.Download();
        if(jsonResponse == null || jsonResponse.isEmpty()){
            return null;
        }
        JsonParser parser = new JsonParser();
        return parser.handleData(jsonResponse);
    }

}
