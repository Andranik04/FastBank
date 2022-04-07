package com.fastcredit.fcbank.navigation

import android.content.Intent
import androidx.lifecycle.lifecycleScope
import dagger.android.support.DaggerFragment

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
abstract class BaseFragment : DaggerFragment()

fun <T : BaseFragment> T.setupNavigation(viewModel: BaseViewModel) {
    this.lifecycleScope.launchWhenStarted {
        viewModel.navigationSharedFlow.collect { screen ->
            when (screen) {
                is Screen.Activity -> {
                    Intent(this@setupNavigation.requireActivity(), screen.activity).also { intent ->
                        screen.bundle?.let { bundle ->
                            intent.putExtras(bundle)
                        }
                        startActivity(intent)
                    }
                }
                is Screen.Fragment -> {
                    (activity as? BaseActivity)?.let {
                        it.navigateTo(screen.fragment, screen.addToBackStack, screen.tag)
                    }
                }
            }
        }
    }
}