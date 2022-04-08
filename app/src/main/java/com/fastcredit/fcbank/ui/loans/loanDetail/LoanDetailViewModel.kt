package com.fastcredit.fcbank.ui.loans.loanDetail

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.fastcredit.fcbank.common.networking.Resource
import com.fastcredit.fcbank.data.model.contract.Loans
import com.fastcredit.fcbank.navigation.BaseViewModel
import com.fastcredit.fcbank.repository.LoansRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoanDetailViewModel @Inject constructor(
    private val loansRepository: LoansRepository
) : BaseViewModel() {



}