package com.training.yasser.facebook;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.training.yasser.facebook.Data.Post;
import com.training.yasser.facebook.Utils.Connection;
import com.training.yasser.facebook.Utils.PostLoader;
import com.training.yasser.facebook.Utils.PostsAdapter;
import com.training.yasser.facebook.Utils.VerticalSpaceItemDecoration;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Post>>{

    private static final String LOG_TAG = MainActivity.class.getName();

    private static final String REQUEST_URL =
            "https://dl.dropboxusercontent.com/s/7rvknz9e6tfprun/facebookFeed.json";
    private static final int VERTICAL_SPACE_RECYCLER = 50;

    private TextView mEmptyStateTextView;
    private RecyclerView mRecyclerView;
    private PostsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mEmptyStateTextView = (TextView) findViewById(R.id.error_text);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_post);
        mAdapter = new PostsAdapter(this, null);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_SPACE_RECYCLER));

        startDownload();

    }

   private void startDownload() {

        if (Connection.checkConnection(this)) {
            LoaderManager loaderManager = getSupportLoaderManager();
            loaderManager.initLoader(0, null, this);

        } else {
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            mEmptyStateTextView.setText(R.string.no_internet_connection);
            mEmptyStateTextView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public Loader<List<Post>> onCreateLoader(int id, Bundle args) {
        return new PostLoader(this, REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Post>> loader, List<Post> data) {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        if(data == null || data.isEmpty()){
            mEmptyStateTextView.setText(R.string.no_post);
            mEmptyStateTextView.setVisibility(View.VISIBLE);
        }else{
            mRecyclerView.setVisibility(View.VISIBLE);
            mAdapter.swap(data);
        }
    }
    @Override
    public void onLoaderReset(Loader<List<Post>> loader) {
    }
}
