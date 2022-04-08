package com.fastcredit.fcbank.ui.loans.loans

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fastcredit.fcbank.databinding.FragmentLoansBinding
import com.fastcredit.fcbank.navigation.BaseFragment
import javax.inject.Inject

class LoansFragment : BaseFragment() {

    companion object {
        fun newInstance() = LoansFragment()
    }

    @Inject
    lateinit var viewModel: LoansViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLoansBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        setupLoansRecyclerView(binding)
        return binding.root
    }

    private fun setupLoansRecyclerView(binding: FragmentLoansBinding) {
        val adapterFeature = LoansMultiHeaderRecyclerAdapter()
        val linearLayoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.VERTICAL,
            false
        )
        
        binding.rvLoans.layoutManager = linearLayoutManager
        binding.rvLoans.setHasFixedSize(true)
        binding.rvLoans.adapter = adapterFeature
    }

}