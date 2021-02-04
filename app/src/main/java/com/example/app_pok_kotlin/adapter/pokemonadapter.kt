package com.example.app_pok_kotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_pok_kotlin.R
import com.example.app_pok_kotlin.models.Result
import com.example.app_pok_kotlin.ui.detail_activity
import com.squareup.picasso.Picasso

class pokemonadapter(private val datalist: List<Result>) : RecyclerView.Adapter<Myholder>() {


    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myholder {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemone, parent, false)

        val holder = Myholder(view)
        view.setOnClickListener {
            val intent = Intent(parent.context, detail_activity::class.java)


            intent.putExtra("name_pokemone", datalist[holder.adapterPosition].name)
            intent.putExtra("image_pokemone", datalist[holder.adapterPosition].getImageUrl())




            parent.context.startActivity(intent)


        }


        return holder

    }

    override fun onBindViewHolder(holder: Myholder, position: Int) {

        val data = datalist[position]
        holder.name.text = data.name
        Picasso.get()
                .load(data.getImageUrl())
                .into(holder.image)


    }


    override fun getItemCount(): Int = datalist.size

}

class Myholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val image: ImageView = itemView.findViewById(R.id.image_of_pokemone)
    val name: TextView = itemView.findViewById(R.id.name_of_pokemon)


}




