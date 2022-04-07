package com.fastcredit.fcbank.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fastcredit.fcbank.di.annotation.ViewModelKey
import com.fastcredit.fcbank.navigation.setupNavigation
import com.fastcredit.fcbank.repository.LoansRepository
import com.fastcredit.fcbank.ui.loans.loanDetail.LoanDetailFragment
import com.fastcredit.fcbank.ui.loans.loanDetail.LoanDetailViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by Sargis Khlopuzyan on 4/7/2022.
 */
@Module(includes = [LoanDetailModule.ProvideViewModel::class])
interface LoanDetailModule {

    @ContributesAndroidInjector(modules = [InjectViewModel::class])
    fun bind(): LoanDetailFragment

    @Module
    class ProvideViewModel {

        @Provides
        @IntoMap
        @ViewModelKey(LoanDetailViewModel::class)
        fun provideViewModel(
            repository: LoansRepository
        ): ViewModel = LoanDetailViewModel(repository)

    }

    @Module
    class InjectViewModel {
        @Provides
        fun provideViewModel(
            factory: ViewModelProvider.Factory,
            target: LoanDetailFragment
        ) = ViewModelProvider(target, factory)[LoanDetailViewModel::class.java].also {
            target.setupNavigation(viewModel = it)
        }
    }


}