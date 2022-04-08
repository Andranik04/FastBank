package com.fastcredit.fcbank.data.remote.api

import com.fastcredit.fcbank.data.model.contract.Loans
import com.fastcredit.fcbank.data.model.contract.TEST_MODEL
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
interface ApiService {

    // Contract
//@GET("Contract/GetContracts?{langId}") // TODO
//    suspend fun getLoans(@Path(value = "langId") langId: Long): Response<Loans>
    @GET("Contract/GetContracts")
    suspend fun getLoans(@Query("langId") langId: Long): Response<Loans>


    //    @GET("https://api.agify.io/?name=meelad")
    @GET
    suspend fun testApiCall(@Query("name") name: String = "meelad"): Response<TEST_MODEL>

}


