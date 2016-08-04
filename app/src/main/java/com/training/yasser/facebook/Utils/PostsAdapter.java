package com.training.yasser.facebook.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.training.yasser.facebook.Data.Post;
import com.training.yasser.facebook.R;

import java.util.List;

/**
 * Created by yasser on 04/08/2016.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context mContext;
    private List<Post> posts;
    private LayoutInflater mInflater;

    public PostsAdapter (Context context, List<Post> posts){
        mInflater = LayoutInflater.from(context);
        mContext = context;
        this.posts = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.post_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.userId.setText(post.getmUserName());
        holder.postTime.setText(post.getmPostTime());
        holder.postText.setText(post.getmPostTxt());
        holder.likes.setText(post.getmLikes());
        holder.comments.setText(post.getmComments());
        holder.shares.setText(post.getmShares());
        Glide
                .with(mContext)
                .load(post.getmUserPic())
                .into(holder.userPic);
        Glide
                .with(mContext)
                .load(post.getmPostImg())
                .into(holder.postImg);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void swap(List<Post> data) {
        if (posts != null) {
            posts.clear();
            posts.addAll(data);
        }
        else {
            posts = data;
        }
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userPic;
        ImageView postImg;
        TextView userId;
        TextView postTime;
        TextView postText;
        TextView likes;
        TextView comments;
        TextView shares;

        public ViewHolder(View itemView) {
            super(itemView);
            userPic = (ImageView)itemView.findViewById(R.id.user_pic);
            postImg = (ImageView)itemView.findViewById(R.id.post_image);
            userId = (TextView)itemView.findViewById(R.id.user_id);
            postTime = (TextView)itemView.findViewById(R.id.post_time);
            postText = (TextView)itemView.findViewById(R.id.post_text);
            likes = (TextView)itemView.findViewById(R.id.likes);
            comments = (TextView)itemView.findViewById(R.id.comments);
            shares = (TextView)itemView.findViewById(R.id.shares);
        }
    }
}
