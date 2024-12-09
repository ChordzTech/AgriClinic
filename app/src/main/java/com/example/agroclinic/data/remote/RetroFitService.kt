package com.example.agroclinic.data.remote


import com.example.agroclinic.data.response.PrastavikResponse
import com.example.agroclinic.data.response.SoilResponse
import com.example.agroclinic.data.response.SugarCaneResponse
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetroFitService {


    @GET("allprastavik/")
    suspend fun getPrastavik(): Response<PrastavikResponse>

    @GET("allmati/")
    suspend fun getSoil(): Response<SoilResponse>

    @GET("allsugarcane/")
    suspend fun getSugarCane(): Response<SugarCaneResponse>


    companion object {
        var retrofitService: RetroFitService? = null
        fun getInstance(): RetroFitService {

            val httpClientBuilder = OkHttpClient.Builder()
            httpClientBuilder.addInterceptor(Interceptor { chain ->
                val requestBuilder: Request.Builder = chain.request().newBuilder()
                requestBuilder.header("Content-Type", "application/json")
                chain.proceed(requestBuilder.build())
            })

            val gson = GsonBuilder().setLenient().create()
            if (retrofitService == null) {

                //This Below Url Has to be Replaced with Current Url

                val retrofit = Retrofit.Builder().baseUrl("https://agriclinicapi.beatsacademy.in/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(getLogger())
                    .client(httpClientBuilder.build()).build()
                retrofitService = retrofit.create(RetroFitService::class.java)
            }
            return retrofitService!!
        }

        private fun getHeaders(): OkHttpClient {
            val httpClient = OkHttpClient()
            val interceptors = httpClient.networkInterceptors as ArrayList<Interceptor>
            interceptors.add(Interceptor { chain ->
                val requestBuilder: Request.Builder = chain.request().newBuilder()
                requestBuilder.header("Content-Type", "application/json")
                chain.proceed(requestBuilder.build())
            })
            return httpClient;
        }

        private fun getLogger(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            return OkHttpClient.Builder().addInterceptor(interceptor).build();
        }

    }
}