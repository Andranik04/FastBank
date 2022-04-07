package com.fastcredit.fcbank.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fastcredit.fcbank.di.annotation.ViewModelKey
import com.fastcredit.fcbank.navigation.setupNavigation
import com.fastcredit.fcbank.repository.LoansRepository
import com.fastcredit.fcbank.ui.loans.loans.LoansFragment
import com.fastcredit.fcbank.ui.loans.loans.LoansViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
@Module(includes = [LoansModule.ProvideViewModel::class])
interface LoansModule {

    @ContributesAndroidInjector(modules = [InjectViewModel::class])
    fun bind(): LoansFragment

    @Module
    class ProvideViewModel {

        @Provides
        @IntoMap
        @ViewModelKey(LoansViewModel::class)
        fun provideViewModel(
            repository: LoansRepository
        ): ViewModel = LoansViewModel(repository)

    }

    @Module
    class InjectViewModel {
        @Provides
        fun provideViewModel(
            factory: ViewModelProvider.Factory,
            target: LoansFragment
        ) = ViewModelProvider(target, factory)[LoansViewModel::class.java].also {
            target.setupNavigation(viewModel = it)
        }
    }

}