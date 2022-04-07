package com.fastcredit.fcbank.data.remote.api

import com.fastcredit.fcbank.data.model.contract.Loans
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
interface ApiService {

    // Contract

    @GET("Contract/GetContracts/{langId}") // TODO
    suspend fun getLoans(@Path(value = "langId") langId: Long): Response<Loans>

}