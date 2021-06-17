package com.mj.aop_part4_chapter02

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mj.aop_part4_chapter02.service.MusicDto
import com.mj.aop_part4_chapter02.service.MusicService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PlayerFragment : Fragment(R.layout.fragment_player) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        getMusicListFromServer()
    }

    private fun getMusicListFromServer() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://run.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(MusicService::class.java)
                .also {
                    it.listMusics()
                            .enqueue(object : Callback<MusicDto> {
                                override fun onResponse(call: Call<MusicDto>, response: Response<MusicDto>) {
                                    Log.d("PlayerFragment", "${response.body()}")
                                }

                                override fun onFailure(call: Call<MusicDto>, t: Throwable) {
                                    Log.d("PlayerFragment", "$t")
                                }

                            })
                }
    }

    companion object {
        fun newInstance(): PlayerFragment {
            return PlayerFragment()
        }
    }


}