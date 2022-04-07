package com.fastcredit.fcbank.di.component

import android.content.Context
import com.fastcredit.fcbank.FastBankApp
import com.fastcredit.fcbank.di.module.AppModule
import com.fastcredit.fcbank.di.module.LoanDetailModule
import com.fastcredit.fcbank.di.module.LoansModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        LoansModule::class,
        LoanDetailModule::class
    ]
)
interface AppComponent : AndroidInjector<FastBankApp> {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Context
        ): AppComponent
    }

}