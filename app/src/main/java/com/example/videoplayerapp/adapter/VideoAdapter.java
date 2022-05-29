package com.example.videoplayerapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videoplayerapp.R;
import com.example.videoplayerapp.model.VideoRVModel;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private ArrayList<VideoRVModel> videoRVModelArrayList;
    private Context context;
    private VideoClickInterface videoClickInterface;

    public VideoAdapter(ArrayList<VideoRVModel> videoRVModelArrayList, Context context, VideoClickInterface videoClickInterface) {
        this.videoRVModelArrayList = videoRVModelArrayList;
        this.context = context;
        this.videoClickInterface = videoClickInterface;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {
        VideoRVModel videoRVModel = videoRVModelArrayList.get(position);
        holder.thumbnailIV.setImageBitmap(videoRVModel.getThumbNail());
        holder.itemView.setOnClickListener(view -> {
            videoClickInterface.onVideoClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return videoRVModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView thumbnailIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnailIV = itemView.findViewById(R.id.idIVThumbNail);
        }
    }

    public interface VideoClickInterface{
        void onVideoClick(int position);
    }
}
