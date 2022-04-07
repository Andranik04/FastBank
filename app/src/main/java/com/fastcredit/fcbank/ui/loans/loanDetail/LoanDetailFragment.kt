package com.fastcredit.fcbank.ui.loans.loanDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fastcredit.fcbank.databinding.FragmentLoanDetailBinding
import com.fastcredit.fcbank.navigation.BaseFragment
import javax.inject.Inject

class LoanDetailFragment : BaseFragment() {

    companion object {
        fun newInstance() = LoanDetailFragment()
    }

    @Inject
    lateinit var viewModel: LoanDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLoanDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

}