package com.example.parcial2episodios

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class EpisodioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episodioactivity)

        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val episodeTextView = findViewById<TextView>(R.id.episodeTextView)
        val seasonTextView = findViewById<TextView>(R.id.seasonTextView)
        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)
        val episodeImageView = findViewById<ImageView>(R.id.episodioImageView)
        val backButton = findViewById<Button>(R.id.backButton) // Botón "Volver"

        val episodio = intent.getSerializableExtra("Episodio") as? Episodio

        if (episodio != null) {
            nameTextView.text = "Nombre: ${episodio.name}"
            episodeTextView.text = "Capitulo: ${episodio.episode}"
            seasonTextView.text = "Temporada: ${episodio.season}"
            descriptionTextView.text = "Descripción: ${episodio.description}"
            Glide.with(this).load(episodio.thumbnailUrl).into(episodeImageView)
        }

        // Configurar el botón "Volver" para finalizar la actividad
        backButton.setOnClickListener {
            finish() // Termina la actividad actual y regresa a la anterior
        }
    }
}
