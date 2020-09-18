package com.pieterventer.quotemeonthis.data.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RestClient {

    private const val TIMEOUT_SECONDS = 15L

    private val client: OkHttpClient by lazy {
        val clientBuilder = OkHttpClient.Builder()
            .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(interceptor)
        }

        clientBuilder.build()
    }

    private val baseRetrofitInstance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val QUOTE_API: QuoteApi by lazy {
        baseRetrofitInstance.create(QuoteApi::class.java)
    }

    private const val baseUrl = "https://quote-garden.herokuapp.com/api/v2/"
}