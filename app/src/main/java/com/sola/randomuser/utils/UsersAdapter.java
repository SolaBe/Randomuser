package com.sola.randomuser.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sola.randomuser.R;
import com.sola.randomuser.models.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sola2Be on 29.05.2017.
 */

public class UsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int USER = 0;
    private static final int PROGRESS = 1;

    private List<Result> results;
    private Context context;
    private View.OnClickListener clickListener;
    private boolean isLoading;

    public UsersAdapter(Context context, View.OnClickListener listener) {
        this.context = context;
        this.clickListener = listener;
        results = new ArrayList<>();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder = null;

        switch(viewType) {
            case USER :
                holder = new UsersViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.users_item, parent, false));
                break;
            case PROGRESS :
                holder = new ProgressViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.progress_item, parent, false));
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Result item = results.get(position);

        switch (getItemViewType(position)) {
            case USER:
                UsersViewHolder uHolder = (UsersViewHolder) holder;
                Picasso.with(context).load(item.getPicture().getThumbnail())
                        .placeholder(android.R.mipmap.sym_def_app_icon)
                        .into(uHolder.avatar);
                String fullname = item.getName().getTitle() + "." +
                        item.getName().getFirst() + " " +
                        item.getName().getLast();
                uHolder.name.setText(fullname);
                uHolder.login.setText(item.getLogin().getUsername());
                uHolder.gender.setText(item.getGender());
                holder.itemView.setTag(item);
                holder.itemView.setOnClickListener(clickListener);
                break;
            case PROGRESS :
                break;
        }
    }

    @Override
    public int getItemCount() {
        return results == null ? 0 : results.size();
    }


    @Override
    public int getItemViewType(int position) {
        return (position == results.size() - 1 && isLoading) ? PROGRESS : USER;
    }

    public void addItems(List<Result> items) {
        int lastPos = results.size() - 1;
        results.addAll(items);
        notifyItemRangeInserted(lastPos, items.size());
    }

    public void showProgress() {
        isLoading = true;
    }

    public void hideProgress() {
        isLoading = false;
    }


    public static class UsersViewHolder extends RecyclerView.ViewHolder {

        ImageView avatar;
        TextView login;
        TextView name;
        TextView gender;

        public UsersViewHolder(View itemView) {
            super(itemView);

            avatar = (ImageView) itemView.findViewById(R.id.avatar);
            login = (TextView) itemView.findViewById(R.id.login);
            name = (TextView) itemView.findViewById(R.id.name);
            gender = (TextView) itemView.findViewById(R.id.gender);
        }
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {

        public ProgressViewHolder(View itemView) {
            super(itemView);
        }
    }



}
