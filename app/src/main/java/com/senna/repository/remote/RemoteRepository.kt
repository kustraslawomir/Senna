package com.senna.repository.remote


import io.reactivex.Single
import retrofit2.http.POST

interface RemoteRepository {

    @POST("init")
    fun init(): Single<String>
}