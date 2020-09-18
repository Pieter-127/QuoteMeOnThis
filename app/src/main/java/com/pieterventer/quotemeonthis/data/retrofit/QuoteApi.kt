package com.pieterventer.quotemeonthis.data.retrofit

import com.pieterventer.quotemeonthis.data.response.QuoteResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET(value = "quotes")
    suspend fun getQuotes(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 100
    ): Response<QuoteResponse>
}