package com.fastcredit.fcbank.common.extensions

import com.fastcredit.fcbank.common.networking.NoConnectivityException
import com.fastcredit.fcbank.common.networking.Resource
import retrofit2.Response
import java.net.ConnectException

/**
 * Created by Sargis Khlopuzyan on 4/7/2022.
 */

fun <T : Any> Response<T>.getResult(): Resource<T> {
    // TODO consider later api instruction
    return if (this.isSuccessful && this.body() != null) {
        Resource.Success(this.body()!!)
    } else {
        Resource.Error(this.message(), null)
    }
}

fun Throwable?.isNetworkConnectivityException() =
    this is NoConnectivityException || this is ConnectException