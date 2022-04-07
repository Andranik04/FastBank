package com.fastcredit.fcbank.data.remote.retrofit

import com.fastcredit.fcbank.BuildConfig
import com.fastcredit.fcbank.data.remote.interceptors.AddHeaderInterceptor
import com.fastcredit.fcbank.data.remote.interceptors.NetworkConnectionInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
class NetworkService {

    companion object {
        private const val BASE_URL = "http://172.19.245.29:8088/"

        fun initOkHttpClient(
            addHeaderInterceptor: AddHeaderInterceptor,
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): OkHttpClient {

            return OkHttpClient.Builder().apply {
                readTimeout(60, TimeUnit.SECONDS)
                connectTimeout(60, TimeUnit.SECONDS)
                addInterceptor(addHeaderInterceptor)
                addInterceptor(networkConnectionInterceptor)

                // interceptor for logging
                if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.level = HttpLoggingInterceptor.Level.BASIC
                    addInterceptor(logging)
                }

            }.build()
        }

        fun initRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}