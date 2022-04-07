package com.fastcredit.fcbank.common.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 *
 * Helper method for easing the use of ViewModels with a constructor.
 */
inline fun <reified V : ViewModel> Fragment.getViewModel(key: String? = null, noinline factory: () -> V): V {
    @Suppress("UNCHECKED_CAST")
    val viewModelProviderFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T = factory() as T
    }

    return if (key != null) {
        ViewModelProviders.of(this, viewModelProviderFactory)[key, V::class.java]
    } else {
        ViewModelProviders.of(this, viewModelProviderFactory)[V::class.java]
    }
}