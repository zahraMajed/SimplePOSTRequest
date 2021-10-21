package com.example.simplepostrequest

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIinterface {
    @Headers("Content-Type: application/json\n")
    @POST("/custom-people/")
    fun postName(@Body info:myData.myDataItem): Call<myData.myDataItem>

}