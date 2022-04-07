package com.fastcredit.fcbank.ui.loans.loans

import com.fastcredit.fcbank.navigation.BaseViewModel
import com.fastcredit.fcbank.navigation.Screen
import com.fastcredit.fcbank.repository.LoansRepository
import com.fastcredit.fcbank.ui.loans.loanDetail.LoanDetailFragment
import javax.inject.Inject

class LoansViewModel @Inject constructor(
    private val loansRepository: LoansRepository
) : BaseViewModel() {

    fun openLoanDetailScreen() {
        Screen.Fragment(LoanDetailFragment.newInstance(), true, "LoanDetailFragment")
            .also { destinationFragment ->
                navigateTo(destinationFragment)
            }
    }

}