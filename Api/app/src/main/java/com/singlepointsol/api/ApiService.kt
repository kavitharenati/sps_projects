package com.singlepointsol.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("?key=47634762-688ca563c5b4378954b8c09d3&q=nature&image_type=photo&pretty=true")
    suspend fun getNature(): Response<NatureResponse>
}
