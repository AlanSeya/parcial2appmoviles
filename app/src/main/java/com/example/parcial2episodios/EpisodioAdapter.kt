package com.example.parcial2episodios

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class EpisodioAdapter(
    private var episodios: List<Episodio>,
    private val onItemClick: (Episodio) -> Unit
) : RecyclerView.Adapter<EpisodioAdapter.EpisodioViewHolder>() {

    class EpisodioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tvName)
        val episode: TextView = view.findViewById(R.id.tvEpisodio)
        val season: TextView = view.findViewById(R.id.tvseason)
        val image: ImageView = view.findViewById(R.id.ivThumbnail)
        //val description: TextView = view.findViewById(R.id.tvdescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_episodio, parent, false)
        return EpisodioViewHolder(view)
    }

    override fun onBindViewHolder(holder: EpisodioViewHolder, position: Int) {
        val episodio = episodios[position]
        holder.name.text = episodio.name
        holder.episode.text = "Episodio: ${episodio.episode}"
        holder.season.text = "Temporada: ${episodio.season}"
        //holder.description.text = "Descripcion: ${episodio.description}"
        Glide.with(holder.itemView.context).load(episodio.thumbnailUrl).into(holder.image)

        holder.itemView.setOnClickListener { onItemClick(episodio) }
    }

    override fun getItemCount(): Int = episodios.size

    fun updateData(newData: List<Episodio>) {
        episodios = newData
        notifyDataSetChanged()
    }
}


