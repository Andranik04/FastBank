package com.fastcredit.fcbank.ui.app

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.fastcredit.fcbank.R
import com.fastcredit.fcbank.databinding.ActivityMainBinding
import com.fastcredit.fcbank.navigation.BaseActivity
import com.fastcredit.fcbank.navigation.BaseFragment
import com.fastcredit.fcbank.ui.home.HomeFragment

class MainActivity : BaseActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    override fun navigateTo(
        destinationFragment: BaseFragment,
        addToBackStack: Boolean,
        tag: String?
    ) {
        if (supportFragmentManager.findFragmentById(R.id.navigationContainer) == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.navigationContainer, HomeFragment.newInstance()).also {
                    if (addToBackStack) {
                        it.addToBackStack(tag)
                    }
                }
                .commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false

        if (supportFragmentManager.findFragmentById(R.id.navigationContainer) == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.navigationContainer, HomeFragment.newInstance())
//                .addToBackStack(false)
                .commit()
        }

        binding.fab.setOnClickListener {
            Toast.makeText(this, "FAB Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.miHome -> {
                    true
                }
                R.id.miGroups -> {
                    true
                }
                R.id.miHistory -> {
                    true
                }
                R.id.miChar -> {
                    true
                }
                else -> super.onOptionsItemSelected(menuItem)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}