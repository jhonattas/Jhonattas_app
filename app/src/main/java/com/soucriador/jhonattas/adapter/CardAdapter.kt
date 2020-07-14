package com.soucriador.jhonattas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.NetworkImageView
import com.soucriador.jhonattas.R
import com.soucriador.jhonattas.io.AppController
import com.soucriador.jhonattas.model.Project
import java.util.*

class CardAdapter(projects: ArrayList<Project>) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    var mProjects: List<Project> = projects
    var imageLoader: ImageLoader? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.recyclerview_card_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        if (imageLoader == null) {
            imageLoader = AppController.getInstance().imageLoader
        }
        val project = mProjects[i]
        viewHolder.projectsCardTitle.text = project.title
        viewHolder.projectsCardImg.setImageUrl(project.thumbnailUrl, imageLoader)
    }

    override fun getItemCount(): Int {
        return mProjects.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var projectsCardImg: NetworkImageView = itemView.findViewById(R.id.projectsCardImg)
        var projectsCardTitle: TextView = itemView.findViewById(R.id.projectsCardTitle)

        init {
        }
    }

}