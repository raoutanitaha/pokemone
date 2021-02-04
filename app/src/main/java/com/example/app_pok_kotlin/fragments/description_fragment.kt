package com.example.app_pok_kotlin.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app_pok_kotlin.R
import com.example.app_pok_kotlin.models.POKE_det
import com.example.app_pok_kotlin.network.pokservoce
import kotlinx.android.synthetic.main.fragment_description_fragment.*
import kotlinx.android.synthetic.main.fragment_description_fragment.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [description_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class description_fragment : Fragment( ) {



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_description_fragment, container, false)
        val myString:String = arguments?.getString("message").toString()
      view.weight.text=myString
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.glitch.me/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api2 = retrofit.create(pokservoce::class.java)

        api2.fetchPokemonDetails(myString).enqueue(object : Callback<POKE_det> {
            override fun onResponse(call: Call<POKE_det>, response: Response<POKE_det>) {
                Log.d("ppp", "nj7te   ${response.body()}")

                val stringResponse :POKE_det= response.body() as POKE_det

                     for (x in 0 until  stringResponse.size) {
                         height.text="height:   "
                         height.append(stringResponse[x].height)

                         weight.text="weight:  "
                         weight.append(stringResponse[x].weight)
                           type.text="types:   "
                         type.append(stringResponse.get(x).types.toString())
                         description_text.text=stringResponse[x].description
                         val test: List<String> = stringResponse.get(x).types

                     }


            }

            override fun onFailure(call: Call<POKE_det>, t: Throwable) {
                Log.d("kk", "s9te$t")
            }


        })


        return view






    }


}