package com.fastcredit.fcbank.navigation

import android.os.Bundle

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
sealed interface Screen {

    data class Activity(
        val activity: Class<out BaseActivity>,
        val bundle: Bundle? = null
    ) : Screen

    data class Fragment(
        val fragment: BaseFragment,
        val addToBackStack: Boolean = false,
        val tag: String? = null
    ) : Screen

}