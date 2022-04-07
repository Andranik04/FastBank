package com.fastcredit.fcbank.ui.loans

import android.os.Bundle
import com.fastcredit.fcbank.R
import com.fastcredit.fcbank.navigation.BaseActivity
import com.fastcredit.fcbank.navigation.BaseFragment
import com.fastcredit.fcbank.ui.loans.loans.LoansFragment

class LoansActivity : BaseActivity() {

    override fun navigateTo(
        destinationFragment: BaseFragment,
        addToBackStack: Boolean,
        tag: String?
    ) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.navigationContainer, destinationFragment).also {
                if (addToBackStack) {
                    it.addToBackStack(tag)
                }
                it.commit()
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loans)

        if (supportFragmentManager.findFragmentById(R.id.navigationContainer) == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.navigationContainer, LoansFragment.newInstance())
                .commit()
        }
    }

}