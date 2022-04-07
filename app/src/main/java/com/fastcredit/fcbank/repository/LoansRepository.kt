package com.fastcredit.fcbank.repository

import android.util.Log
import com.fastcredit.fcbank.common.extensions.getResult
import com.fastcredit.fcbank.common.networking.Resource
import com.fastcredit.fcbank.data.model.contract.Loans
import com.fastcredit.fcbank.data.remote.api.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.io.IOException

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */

interface LoansRepository {
    suspend fun getContracts(langId: Long): Resource<Loans>
}

class LoansRepositoryImpl(
    private val apiService: ApiService,
    private val coroutineDispatcher: CoroutineDispatcher
) : LoansRepository {

    override suspend fun getContracts(langId: Long): Resource<Loans> =
        withContext(coroutineDispatcher) {
            try {
                apiService.getLoans(langId).getResult()
            } catch (t: Throwable) {
                when (t) {
                    is IOException -> Resource.Error("No Internet connection")
                    else -> Resource.Error("Conversion Error")
                }
            }
        }
}