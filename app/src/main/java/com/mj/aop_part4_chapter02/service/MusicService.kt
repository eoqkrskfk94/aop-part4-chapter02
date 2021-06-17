package com.mj.aop_part4_chapter02.service

import retrofit2.Call
import retrofit2.http.GET

interface MusicService {

    @GET("/v3/508bcb2d-2c54-4c96-a01e-676e78287c36")
    fun listMusics(): Call<MusicDto>
}