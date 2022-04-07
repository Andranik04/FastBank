package com.fastcredit.fcbank.di.factory

import androidx.lifecycle.ViewModelProvider
import com.fastcredit.fcbank.navigation.BaseFragment
import com.fastcredit.fcbank.navigation.BaseViewModel
import com.fastcredit.fcbank.navigation.setupNavigation

/**
 * Created by Sargis Khlopuzyan on 4/7/2022.
 */

inline fun <reified VM : BaseViewModel> viewModelCreator(
//inline fun <reified VM : LoansViewModel> viewModelCreator(
    target: BaseFragment,
    factory: ViewModelProvider.Factory
) = ViewModelProvider(target, factory)[VM::class.java].also {
    target.setupNavigation(viewModel = it)
}