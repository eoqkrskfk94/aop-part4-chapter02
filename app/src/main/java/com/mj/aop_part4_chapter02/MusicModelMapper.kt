package com.mj.aop_part4_chapter02

import com.mj.aop_part4_chapter02.service.MusicEntity

fun MusicEntity.mapper(id: Long): MusicModel =
        MusicModel(
                id = id,
                streamUrl = streamUrl,
                coverUrl = coverUrl,
                track = track,
                artist = artist
        )