package com.fastcredit.fcbank.ui.loans.loans

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.fastcredit.fcbank.common.networking.Resource
import com.fastcredit.fcbank.data.model.contract.Loans
import com.fastcredit.fcbank.navigation.BaseViewModel
import com.fastcredit.fcbank.navigation.Screen
import com.fastcredit.fcbank.repository.LoansRepository
import com.fastcredit.fcbank.ui.loans.loanDetail.LoanDetailFragment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoansViewModel @Inject constructor(
    private val loansRepository: LoansRepository
) : BaseViewModel() {

    private val _stateFlowLoans = MutableStateFlow<Loans?>(null)
    val stateFlowLoans: StateFlow<Loans?> = _stateFlowLoans

    private val _stateFlowLoading = MutableStateFlow<Boolean>(false)
    val stateFlowLoading: StateFlow<Boolean> = _stateFlowLoading

    init {
        viewModelScope.launch {
            loadLoans(langId = 1)
        }
    }

    fun openLoanDetailScreen() {
        Screen.Fragment(LoanDetailFragment.newInstance(), true, "LoanDetailFragment")
            .also { destinationFragment ->
                navigateTo(destinationFragment)
            }
    }

    private suspend fun loadLoans(langId: Long) {
        testApiCall()

//        _stateFlowLoading.value = false
//
//        val response = loansRepository.getContracts(langId = 1)
//        _stateFlowLoading.value = false
//
//        when (response) {
//            is Resource.Success -> {
//                Log.e("LOG_TAG", "Success")
//                _stateFlowLoans.value
//            }
//            is Resource.Error -> {
//                Log.e("LOG_TAG", "Error : ${response.message}")
//            }
//            is Resource.Loading -> {
//                Log.e("LOG_TAG", "Loading")
//            }
//        }
    }

    private suspend fun testApiCall() {
        val response = loansRepository.testApiCall()

        when (response) {
            is Resource.Success -> {
                Log.e("LOG_TAG", "Success")
                _stateFlowLoans.value
            }
            is Resource.Error -> {
                Log.e("LOG_TAG", "Error : ${response.message}")
            }
            is Resource.Loading -> {
                Log.e("LOG_TAG", "Loading")
            }
        }
    }
}