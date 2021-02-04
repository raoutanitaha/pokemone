package com.example.app_pok_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_pok_kotlin.R
import com.example.app_pok_kotlin.models.POKE_det
import com.squareup.picasso.Picasso
import java.util.*


class evolutionadapter(private val test: POKE_det): RecyclerView.Adapter<evolutionadapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val image :ImageView= itemView.findViewById(R.id.imageView_test)
        val textt :TextView= itemView.findViewById(R.id.kawi)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): evolutionadapter.ViewHolder {
     val view =LayoutInflater.from(parent.context).inflate(R.layout.eevolution_pok, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: evolutionadapter.ViewHolder, position: Int) {



        val data = test[position]

        for(x in data.family.evolutionLine.indices) {
            holder.textt.text = data.family.evolutionLine[x]
            val y: String = data.family.evolutionLine[x]
            val url="https://img.pokemondb.net/artwork/large/charizard.jpg"
            Picasso.get().load(url).into(holder.image)

        }



       // Picasso.get().load(" https://img.pokemondb.net/sprites/home/normal/$y.png").into(holder.image)
        //Picasso.get().load(" https://img.pokemondb.net/artwork/large/charizard.jpg").into(holder.image)
    }

    override fun getItemCount()= test.size
}








