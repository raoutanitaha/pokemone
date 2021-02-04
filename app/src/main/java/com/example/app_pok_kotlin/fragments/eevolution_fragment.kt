package com.example.app_pok_kotlin.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.app_pok_kotlin.R
import com.example.app_pok_kotlin.models.POKE_det
import com.example.app_pok_kotlin.network.pokservoce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [description_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class eevolution_fragment : Fragment( ) {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_eevolution_fragment, container, false)
        val myString:String = arguments?.getString("evolution").toString()
        val evolutionline: List<String>? = null

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.glitch.me/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api2 = retrofit.create(pokservoce::class.java)

        api2.fetchPokemonDetails(myString).enqueue(object : Callback<POKE_det> {
            override fun onResponse(call: Call<POKE_det>, response: Response<POKE_det>) {
                Log.d("bbbb", "nj7te   ${response.body()}")

                val stringResponse: POKE_det = response.body() as POKE_det

                for (x in 0 until stringResponse.size) {
                    if (response.body() != null) {
                        val evolutionline: ArrayList<String> =
                            stringResponse[x].family.evolutionLine as ArrayList<String>


                        //showdata(response.body()!!)
                        for (i in 1 until evolutionline.size) {
                            val url: String = evolutionline.toString()
                            val aa: String = evolutionline.toString()
                            val a = aa.substring(1)
                            val b = a.substring(0, a.length - 1)
                            val virgule = ","
                            val c = b.replace(" ".toRegex(), "")
                            val mots = c.split(virgule.toRegex()).toTypedArray()
                            val cap =
                                mots[i - 1].substring(0, 1).toLowerCase() + mots[i - 1].substring(1)
                            if (evolutionline.size == 1) {
                                val pok1 =
                                    mots[0].substring(0, 1).toLowerCase() + mots[0].substring(
                                        1
                                    )
                                val rl =
                                    view.findViewById<View>(R.id.relative) as RelativeLayout
                                val imageView118 = ImageView(activity)
                                rl.addView(imageView118)
                                val par1 = imageView118.layoutParams as RelativeLayout.LayoutParams
                                par1.width = 400
                                par1.height = 400
                                par1.leftMargin = 0
                                par1.bottomMargin = 300
                                par1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                                imageView118.layoutParams = par1
                                val url1 = "https://img.pokemondb.net/artwork/large/$pok1.jpg"
                                Glide.with(context!!)
                                    .load(url1)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL) //cache 0
                                    .into(imageView118)
                            }
                            if (evolutionline.size == 2) {
                                val pok1 =
                                    mots[0].substring(0, 1).toLowerCase() + mots[0].substring(1)
                                val pok2 =
                                    mots[1].substring(0, 1).toLowerCase() + mots[1].substring(1)
                                val rl = view.findViewById<View>(R.id.relative) as RelativeLayout
                                val imageView1 = ImageView(activity)
                                val imageView2 = ImageView(activity)
                                rl.addView(imageView1)
                                rl.addView(imageView2)
                                val par1 = imageView1.layoutParams as RelativeLayout.LayoutParams
                                val par2 = imageView2.layoutParams as RelativeLayout.LayoutParams
                                par1.width = 300
                                par1.height = 300
                                par1.leftMargin = 0
                                par1.bottomMargin = 300
                                par1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                                imageView1.layoutParams = par1
                                par2.width = 300
                                par2.height = 300
                                par2.leftMargin = 350
                                par2.bottomMargin = 300
                                par2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                                imageView2.layoutParams = par2
                                val url1 = "https://img.pokemondb.net/artwork/large/$pok1.jpg"
                                val url2 = "https://img.pokemondb.net/artwork/large/$pok2.jpg"
                                Glide.with(context!!)
                                    .load(url1)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL) //cache 0
                                    .into(imageView1)
                                Glide.with(context!!)
                                    .load(url2)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL) //cache 0
                                    .into(imageView2)
                            }
                            if (evolutionline.size == 3) {
                                val pok1 =
                                    mots[0].substring(0, 1).toLowerCase() + mots[0].substring(1)
                                val pok2 =
                                    mots[1].substring(0, 1).toLowerCase() + mots[1].substring(1)
                                val pok3 =
                                    mots[2].substring(0, 1).toLowerCase() + mots[2].substring(1)
                                val rl = view.findViewById<View>(R.id.relative) as RelativeLayout
                                val imageView1 = ImageView(activity)
                                val imageView2 = ImageView(activity)
                                val imageView3 = ImageView(activity)
                                rl.addView(imageView1)
                                rl.addView(imageView2)
                                rl.addView(imageView3)
                                val par1 = imageView1.layoutParams as RelativeLayout.LayoutParams
                                val par2 = imageView2.layoutParams as RelativeLayout.LayoutParams
                                val par3 = imageView3.layoutParams as RelativeLayout.LayoutParams
                                par1.width = 300
                                par1.height = 300
                                par1.leftMargin = 0
                                par1.bottomMargin = 300
                                par1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                                imageView1.layoutParams = par1
                                par2.width = 300
                                par2.height = 300
                                par2.leftMargin = 350
                                par2.bottomMargin = 300
                                par2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                                imageView2.layoutParams = par2
                                par3.width = 300
                                par3.height = 300
                                par3.leftMargin = 700
                                par3.bottomMargin = 300
                                par3.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                                imageView3.layoutParams = par3
                                val url1 = "https://img.pokemondb.net/artwork/large/$pok1.jpg"
                                val url2 = "https://img.pokemondb.net/artwork/large/$pok2.jpg"
                                val url3 = "https://img.pokemondb.net/artwork/large/$pok3.jpg"
                                Glide.with(context!!)
                                    .load(url1)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL) //cache 0
                                    .into(imageView1)
                                Glide.with(context!!)
                                    .load(url2)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL) //cache 0
                                    .into(imageView2)
                                Glide.with(context!!)
                                    .load(url3)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL) //cache 0
                                    .into(imageView3)
                            }


                        }


                        //  val url = "https://img.pokemondb.net/artwork/large/${stringResponse[x].family.evolutionLine[1]}.jpg"

                    }


                    /*
                val stringResponse :POKE_det= response.body() as POKE_det
                for (x in 0 until  stringResponse.size) {
                    textView2.text = stringResponse[x].family.evolutionLine[1]


                }*/


                }
            }

            override fun onFailure(call: Call<POKE_det>, t: Throwable) {
                Log.d("kk", "s9te$t")
            }


        })







        return view






    }
  /* private fun showdata(pok_disp: POKE_det) {


            recy_1.apply {
            layoutManager = GridLayoutManager(
                activity, 3
            )

            if (pok_disp != null) {
                adapter = evolutionadapter(pok_disp)
            }

        }

    }
*/


}