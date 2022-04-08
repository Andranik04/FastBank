package com.fastcredit.fcbank.data.remote.retrofit

import com.fastcredit.fcbank.BuildConfig
import com.fastcredit.fcbank.data.remote.interceptors.AddHeaderInterceptor
import com.fastcredit.fcbank.data.remote.interceptors.NetworkConnectionInterceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
class NetworkService {

    companion object {
        //        private const val BASE_URL = "http://172.19.245.29:8088/"
        private const val BASE_URL = "https://api.agify.io/"

        fun initOkHttpClient(
            addHeaderInterceptor: AddHeaderInterceptor,
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): OkHttpClient {

            return OkHttpClient.Builder().apply {
                readTimeout(60, TimeUnit.SECONDS)
                connectTimeout(60, TimeUnit.SECONDS)
//                addInterceptor(addHeaderInterceptor)
//                addInterceptor(networkConnectionInterceptor)

                // interceptor for logging
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor().also {
                        it.level = HttpLoggingInterceptor.Level.BASIC
                        addInterceptor(it)
                    }
                }

            }.build()
        }

        fun initRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(UnitConverterFactory) // The important line
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    object UnitConverterFactory : Converter.Factory() {
        override fun responseBodyConverter(
            type: Type,
            annotations: Array<out Annotation>,
            retrofit: Retrofit
        ): Converter<ResponseBody, *>? {
            return if (type == Unit::class.java) UnitConverter else null
        }

        private object UnitConverter : Converter<ResponseBody, Unit> {
            override fun convert(value: ResponseBody) {
                value.close()
            }
        }
    }
}