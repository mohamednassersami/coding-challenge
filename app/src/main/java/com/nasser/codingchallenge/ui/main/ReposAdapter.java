package com.nasser.codingchallenge.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nasser.codingchallenge.pojo.RepoModel;
import com.nasser.codingchallenge.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.RepoViewHolder> {
    private List<RepoModel> reposList = new ArrayList<>();

    /////
    //review context and picasso
    /////
    Context context  ;

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RepoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.repoName.setText(reposList.get(position).getName());
        holder.repoDescription.setText(reposList.get(position).getDescription());
        holder.numOfstars.setText(reposList.get(position).getOwner().getStarredUrl());
        holder.ownerName.setText(reposList.get(position).getOwner().getUrl());
        Picasso.with(this.context)
                .load(reposList.get(position).getOwner().getAvatarUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .fit()
                .into(holder.owenerAvatar);
    }

    @Override
    public int getItemCount() {
        return reposList.size();
    }

    public void setList(List<RepoModel> reposList) {
        this.reposList = reposList;
        notifyDataSetChanged();
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder {
        TextView repoName, repoDescription, numOfstars, ownerName;
        ImageView owenerAvatar;
        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            repoName = itemView.findViewById(R.id.reponame);
            repoDescription = itemView.findViewById(R.id.Repodescription);
            numOfstars = itemView.findViewById(R.id.numOfStars);
            ownerName = itemView.findViewById(R.id.repoOwerName);
            owenerAvatar = itemView.findViewById(R.id.avatarOfOwner);
        }
    }
}
