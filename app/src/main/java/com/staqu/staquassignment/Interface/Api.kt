package com.staqu.staquassignment.Interface

import com.staqu.staquassignment.Model.NoAnswersData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("no-answers")
    fun getStackOverFlowList(
        @Query("order") order:String,
        @Query("sort") sort:String,
        @Query("site") site:String
    ): Call<NoAnswersData>

}