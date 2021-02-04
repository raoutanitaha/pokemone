package com.example.app_pok_kotlin.ui

import android.annotation.SuppressLint
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.app_pok_kotlin.R
import com.example.app_pok_kotlin.fragments.description_fragment
import com.example.app_pok_kotlin.fragments.eevolution_fragment
import com.example.app_pok_kotlin.models.POKE_det
import com.example.app_pok_kotlin.network.pokservoce
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_activity.*
import kotlinx.android.synthetic.main.fragment_eevolution_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.floatArrayOf as kotlinFloatArrayOf

class detail_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        // detail display
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.cornerRadii = kotlinFloatArrayOf(0f, 0f, 0f, 0f, 150f, 150f, 150f, 150f)
        val actionBar = supportActionBar
        actionBar!!.title = "details of the pokemon "


        val name_pokemone: String = intent.getStringExtra("name_pokemone").toString()
        val pic_pokemone = intent.getStringExtra("image_pokemone")
        val description = description_fragment()
        val evolution = eevolution_fragment()
        pokemone_name_detail.text = name_pokemone
        Picasso.get()
            .load(pic_pokemone)
            .into(image_pok_detail)
        makeCurrentFragment(description)

        val bundle = Bundle()
        bundle.putString("message", name_pokemone)

        description.arguments = bundle
        val bundle2 = Bundle()
        bundle2.putString("evolution", pokemone_name_detail.text.toString())

        evolution.arguments = bundle2

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.glitch.me/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api2 = retrofit.create(pokservoce::class.java)

        api2.fetchPokemonDetails(name_pokemone).enqueue(object : Callback<POKE_det> {
            @SuppressLint("ResourceAsColor")
            override fun onResponse(call: Call<POKE_det>, response: Response<POKE_det>) {
                Log.d("ppp", "nj7te   ${response.body()}")

                val stringResponse: POKE_det = response.body() as POKE_det

                for (x in 0 until stringResponse.size) {
                    var test: String = stringResponse.get(x).types.toString()
                    var test2: Int = stringResponse[x].family.id
                   // textView.text = test2.toString()

                    if (test != null) {
                        if (test.contains(",")) {
                            val virgule = ","
                            val mots: Array<String> =
                                test.split(virgule.toRegex()).toTypedArray()
                            val type = mots[0].substring(1)
                            test = type
                        } else {
                            val type: String = test.substring(1)
                            val type1 = type.substring(0, type.length - 1)
                            test = type1
                        }
                    }

                    when (test) {
                        "Steel" -> {
                            my_nav_bar.setBackgroundResource(R.color.coloracier)
                            //shape.setColor(resources.getColor(R.color.coloracier))
                            //test_loune.setBackgroundColor(R.color.coloracier)
                            test_loune.setBackgroundResource(R.color.coloracier)
                            pokemone_name_detail.setBackgroundResource(R.color.coloracier)
                        }
                        "Ground" -> {
                            my_nav_bar.setBackgroundResource(R.color.colorsol)
                            //shape.setColor(resources.getColor(R.color.colorsol))
                            test_loune.setBackgroundResource(R.color.colorsol)
                            pokemone_name_detail.setBackgroundResource(R.color.colorsol)
                        }
                        "Fighting" -> {
                            my_nav_bar.setBackgroundResource(R.color.colorcombat)
                            //shape.setColor(resources.getColor(R.color.colorcombat))
                            test_loune.setBackgroundResource(R.color.colorcombat)
                            pokemone_name_detail.setBackgroundResource(R.color.colorcombat)
                        }
                        "Dragon" -> {
                            my_nav_bar.setBackgroundResource(R.color.colordragon)
                            //shape.setColor(resources.getColor(R.color.colordragon))
                            test_loune.setBackgroundResource(R.color.colordragon)
                            pokemone_name_detail.setBackgroundResource(R.color.colordragon)
                        }
                        "Fairy" -> {
                            my_nav_bar.setBackgroundResource(R.color.colorfee)
                            //shape.setColor(resources.getColor(R.color.colorfee))
                            test_loune.setBackgroundResource(R.color.colorfee)
                            pokemone_name_detail.setBackgroundResource(R.color.colorfee)
                        }

                        "Normal" -> {
                            my_nav_bar.setBackgroundResource(R.color.colornormal)
                            //shape.setColor(resources.getColor(R.color.colornormal))
                            test_loune.setBackgroundResource(R.color.colornormal)
                            pokemone_name_detail.setBackgroundResource(R.color.colornormal)
                        }
                        "Ghost" -> {
                            my_nav_bar.setBackgroundResource(R.color.colorspectre)
                            //    shape.setColor(resources.getColor(R.color.colorspectre))
                            test_loune.setBackgroundResource(R.color.colorspectre)

                            pokemone_name_detail.setBackgroundResource(R.color.colorspectre)
                        }
                        "Flying" -> {
                            my_nav_bar.setBackgroundResource(R.color.colorvol)
                            //shape.setColor(resources.getColor(R.color.colorvol))
                            test_loune.setBackgroundResource(R.color.colorvol)
                            pokemone_name_detail.setBackgroundResource(R.color.colorvol)
                        }
                        "Psychic" -> {
                            my_nav_bar.setBackgroundResource(R.color.colorpsy)
                            //shape.setColor(resources.getColor(R.color.colorpsy))
                            test_loune.setBackgroundResource(R.color.colorpsy)
                            pokemone_name_detail.setBackgroundResource(R.color.colorpsy)
                        }
                        "Grass" -> {
                            my_nav_bar.setBackgroundResource(R.color.colorplante)
                            //shape.setColor(resources.getColor(R.color.colorplante))
                            test_loune.setBackgroundResource(R.color.colorplante)
                            pokemone_name_detail.setBackgroundResource(R.color.colorplante)

                        }
                        "Fire" -> {
                            my_nav_bar.setBackgroundResource(R.color.colorfeu)
                            //shape.setColor(resources.getColor(R.color.colorfeu))
                            test_loune.setBackgroundResource(R.color.colorfeu)
                            pokemone_name_detail.setBackgroundResource(R.color.colorfeu)
                            //testtaha.setBackgroundResource(R.color.colorfeu)

                        }
                        "Water" -> {
                            my_nav_bar.setBackgroundResource(R.color.coloreau)
                            // shape.setColor(resources.getColor(R.color.coloreau))
                            test_loune.setBackgroundResource(R.color.coloreau)
                            pokemone_name_detail.setBackgroundResource(R.color.coloreau)
                        }
                        "Electric" -> {
                            my_nav_bar.setBackgroundResource(R.color.colorelectrik)
                            //shape.setColor(resources.getColor(R.color.colorelectrik))
                            test_loune.setBackgroundResource(R.color.colorelectrik)
                            pokemone_name_detail.setBackgroundResource(R.color.colorelectrik)
                        }
                        "Poison" -> {
                            my_nav_bar.setBackgroundResource(R.color.colorpoison)
                            //shape.setColor(resources.getColor(R.color.colorpoison))
                            test_loune.setBackgroundResource(R.color.colorpoison)
                            pokemone_name_detail.setBackgroundResource(R.color.colorpoison)
                        }
                        "Bug" -> {
                            my_nav_bar.setBackgroundResource(R.color.colorinsecte)
                            //shape.setColor(resources.getColor(R.color.colorinsecte))
                            test_loune.setBackgroundResource(R.color.colorinsecte)
                            pokemone_name_detail.setBackgroundResource(R.color.colorinsecte)
                        }
                        "Dark" -> {
                            my_nav_bar.setBackgroundResource(R.color.colortenebre)
                            //shape.setColor(resources.getColor(R.color.colortenebre))
                            test_loune.setBackgroundResource(R.color.colortenebre)
                            pokemone_name_detail.setBackgroundResource(R.color.colortenebre)
                        }
                        "Ice" -> {
                            my_nav_bar.setBackgroundResource(R.color.colorglace)
                            //shape.setColor(resources.getColor(R.color.colorglace))
                            test_loune.setBackgroundResource(R.color.colorglace)

                            pokemone_name_detail.setBackgroundResource(R.color.colorglace)
                        }
                        "Rock" -> {
                            my_nav_bar.setBackgroundResource(R.color.colorroche)
                            //shape.setColor(resources.getColor(R.color.colorroche))
                            test_loune.setBackgroundResource(R.color.colorroche)
                            pokemone_name_detail.setBackgroundResource(R.color.colorroche)
                        }
                    }
                }


            }

            override fun onFailure(call: Call<POKE_det>, t: Throwable) {
                Log.d("kk", "s9te$t")
            }


        })


        my_nav_bar.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.ic_description -> makeCurrentFragment(description)
                R.id.ic_evolution -> makeCurrentFragment(evolution)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
    }

}
