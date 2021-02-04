package com.example.app_pok_kotlin.ui

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.app_pok_kotlin.R
import com.example.app_pok_kotlin.adapter.pokemonadapter
import com.example.app_pok_kotlin.models.pokemone
import com.example.app_pok_kotlin.network.pokservoce

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gen1.setImageResource(R.drawable.pokeopen);

        networkcall(151, 0)
        gen1.setOnClickListener {
            gen1.setImageResource(R.drawable.pokeopen);
            gen2.setImageResource(R.drawable.pokeballred);
            gen3.setImageResource(R.drawable.pokeballred);
            gen4.setImageResource(R.drawable.pokeballred);
            gen5.setImageResource(R.drawable.pokeballred);
            gen6.setImageResource(R.drawable.pokeballred);
            gen7.setImageResource(R.drawable.pokeballred);
            gen8.setImageResource(R.drawable.pokeballred);
            val actionBar = supportActionBar
            actionBar!!.title = "generation 1"
            networkcall(151, 0)

        }
        gen2.setOnClickListener {
            gen1.setImageResource(R.drawable.pokeballred);
            gen2.setImageResource(R.drawable.pokeopen);
            gen3.setImageResource(R.drawable.pokeballred);
            gen4.setImageResource(R.drawable.pokeballred);
            gen5.setImageResource(R.drawable.pokeballred);
            gen6.setImageResource(R.drawable.pokeballred);
            gen7.setImageResource(R.drawable.pokeballred);
            gen8.setImageResource(R.drawable.pokeballred);
            val actionBar = supportActionBar
            actionBar!!.title = "generation 2"

            networkcall(151, 151)

        }

        gen3.setOnClickListener {
            gen1.setImageResource(R.drawable.pokeballred);
            gen2.setImageResource(R.drawable.pokeballred);
            gen3.setImageResource(R.drawable.pokeopen);
            gen4.setImageResource(R.drawable.pokeballred);
            gen5.setImageResource(R.drawable.pokeballred);
            gen6.setImageResource(R.drawable.pokeballred);
            gen7.setImageResource(R.drawable.pokeballred);
            gen8.setImageResource(R.drawable.pokeballred);
            val actionBar = supportActionBar
            actionBar!!.title = "generation 3"
            networkcall(151, 302)

        }
        gen4.setOnClickListener {
            gen1.setImageResource(R.drawable.pokeballred);
            gen2.setImageResource(R.drawable.pokeballred);
            gen3.setImageResource(R.drawable.pokeballred);
            gen4.setImageResource(R.drawable.pokeopen);
            gen5.setImageResource(R.drawable.pokeballred);
            gen6.setImageResource(R.drawable.pokeballred);
            gen7.setImageResource(R.drawable.pokeballred);
            gen8.setImageResource(R.drawable.pokeballred);
            val actionBar = supportActionBar
            actionBar!!.title = "generation 4"

            networkcall(151, 453)

        }
        gen5.setOnClickListener {
            gen1.setImageResource(R.drawable.pokeballred);
            gen2.setImageResource(R.drawable.pokeballred);
            gen3.setImageResource(R.drawable.pokeballred);
            gen4.setImageResource(R.drawable.pokeballred);
            gen5.setImageResource(R.drawable.pokeopen);
            gen6.setImageResource(R.drawable.pokeballred);
            gen7.setImageResource(R.drawable.pokeballred);
            gen8.setImageResource(R.drawable.pokeballred);
            val actionBar = supportActionBar
            actionBar!!.title = "generation 5"

            networkcall(151, 604)

        }
        gen6.setOnClickListener {
            gen1.setImageResource(R.drawable.pokeballred);
            gen2.setImageResource(R.drawable.pokeballred);
            gen3.setImageResource(R.drawable.pokeballred);
            gen4.setImageResource(R.drawable.pokeballred);
            gen5.setImageResource(R.drawable.pokeballred);
            gen6.setImageResource(R.drawable.pokeopen);
            gen7.setImageResource(R.drawable.pokeballred);
            gen8.setImageResource(R.drawable.pokeballred);
            val actionBar = supportActionBar
            actionBar!!.title = "generation 6"
            networkcall(151, 755)

        }

        gen7.setOnClickListener {
            gen1.setImageResource(R.drawable.pokeballred);
            gen2.setImageResource(R.drawable.pokeballred);
            gen3.setImageResource(R.drawable.pokeballred);
            gen4.setImageResource(R.drawable.pokeballred);
            gen5.setImageResource(R.drawable.pokeballred);
            gen6.setImageResource(R.drawable.pokeballred);
            gen7.setImageResource(R.drawable.pokeopen);
            gen8.setImageResource(R.drawable.pokeballred);
            val actionBar = supportActionBar
            actionBar!!.title = "generation 7"
            networkcall(151, 906)

        }
        gen8.setOnClickListener {
            gen1.setImageResource(R.drawable.pokeballred);
            gen2.setImageResource(R.drawable.pokeballred);
            gen3.setImageResource(R.drawable.pokeballred);
            gen4.setImageResource(R.drawable.pokeballred);
            gen5.setImageResource(R.drawable.pokeballred);
            gen6.setImageResource(R.drawable.pokeballred);
            gen7.setImageResource(R.drawable.pokeballred);
            gen8.setImageResource(R.drawable.pokeopen);
            val actionBar = supportActionBar
            actionBar!!.title = "generation 8"
            networkcall(61, 1057)

        }


    }

    private fun networkcall(limit: Int, offset: Int) {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(pokservoce::class.java)
        api.getinformation(limit, offset).enqueue(object : Callback<pokemone> {
            override fun onResponse(call: Call<pokemone>, response: Response<pokemone>) {

                d("tbom", "nj7te   ${response.body()}")
                if (response.body() != null) {
                    showdata(response.body())
                }


            }


            override fun onFailure(call: Call<pokemone>, t: Throwable) {
                Log.d("taha", "s9te$t")
            }


        })


    }


    private fun showdata(pok_disp: pokemone?) {


        recycler_view.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)

            if (pok_disp != null) {
                adapter = pokemonadapter(pok_disp.results)
            }

        }

    }


}