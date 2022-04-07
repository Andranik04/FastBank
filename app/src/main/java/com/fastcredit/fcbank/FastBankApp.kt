package com.fastcredit.fcbank

import com.fastcredit.fcbank.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
class FastBankApp : DaggerApplication() {

    init {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory()
            .create(this)
    }

}