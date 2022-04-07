package com.fastcredit.fcbank.navigation

import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun navigateTo(
        destinationFragment: BaseFragment,
        addToBackStack: Boolean = false,
        tag: String? = null
    )

}