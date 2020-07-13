package com.soucriador.jhonattas.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.soucriador.jhonattas.R;
import com.soucriador.jhonattas.io.AppController;
import com.soucriador.jhonattas.model.Project;
import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{

    List<Project> mProjects;
    ImageLoader imageLoader;

    public CardAdapter(ArrayList<Project> projects){
        mProjects = projects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_card_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        if(imageLoader == null){
            imageLoader = AppController.getInstance().getImageLoader();
        }

        Project project = mProjects.get(i);
        viewHolder.projects_recycler_view_card_title.setText(project.getTitle());
        viewHolder.projects_recycler_view_card_img.setImageUrl(project.getThumbnailUrl(), imageLoader);
    }

    @Override
    public int getItemCount() {
        return mProjects.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public NetworkImageView projects_recycler_view_card_img;
        public TextView projects_recycler_view_card_title;

        public ViewHolder(View itemView) {
            super(itemView);
            projects_recycler_view_card_img  = (NetworkImageView) itemView.findViewById(R.id.projects_recycler_view_card_img);
            projects_recycler_view_card_title = (TextView)itemView.findViewById(R.id.projects_recycler_view_card_title);
        }
    }
}