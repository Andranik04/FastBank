package com.fastcredit.fcbank.data.remote.interceptors

import com.fastcredit.fcbank.common.constant.Constants.DataStore.Companion.ACCESS_TOKEN
import com.fastcredit.fcbank.data.local.DataStoreUtil
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
class AddHeaderInterceptor @Inject constructor(private val dataStoreUtil: DataStoreUtil) :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val token = runBlocking {
            dataStoreUtil.readStringFromDataStore(ACCESS_TOKEN) ?: ""
        }

        builder
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .header("token", token)

        return chain.proceed(builder.build())
    }

}