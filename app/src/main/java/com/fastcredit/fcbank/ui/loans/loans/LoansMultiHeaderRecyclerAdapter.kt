package com.fastcredit.fcbank.ui.loans.loans

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fastcredit.fcbank.R
import com.fastcredit.fcbank.common.BindableAdapter
import com.fastcredit.fcbank.data.model.contract.BankOffer
import com.fastcredit.fcbank.data.model.contract.Contract
import com.fastcredit.fcbank.data.model.contract.Loans
import com.fastcredit.fcbank.databinding.LayoutLoansBankOfferBinding
import com.fastcredit.fcbank.databinding.LayoutLoansHeaderBinding
import com.fastcredit.fcbank.databinding.LayoutLoansItemBinding

/**
 * Created by Sargis Khlopuzyan on 4/8/2022.
 */
class LoansMultiHeaderRecyclerAdapter(
    private var loans: Loans? = null
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    BindableAdapter<Loans> {

    private enum class ViewType(var value: Int) {
        VIEW_TYPE_HEADER(1),
        VIEW_TYPE_BANK_OFFERS(2),
        VIEW_TYPE_LOANS_ITEM(3),
    }

    private var bankOffersPosition = -1
    private var loansHeaderPosition = -1
    private var guaranteedLoansHeaderPosition = -1

    private fun updateViewTypePositions() {
        bankOffersPosition = -1
        loansHeaderPosition = -1
        guaranteedLoansHeaderPosition = -1

        if (!loans?.bankOffer.isNullOrEmpty()) {
            bankOffersPosition = 0
        }

        if (!loans?.contracts.isNullOrEmpty()) {
            loansHeaderPosition = if (bankOffersPosition != -1) 1 else 0
        }

        if (!loans?.guaranteedContracts.isNullOrEmpty()) {
            guaranteedLoansHeaderPosition = if (bankOffersPosition != -1) 1 else 0
            if (!loans?.contracts.isNullOrEmpty()) {
                guaranteedLoansHeaderPosition += loans!!.contracts!!.size + 1
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.VIEW_TYPE_BANK_OFFERS.value -> {
                val binding: LayoutLoansBankOfferBinding =
                    LayoutLoansBankOfferBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                BankOffersViewHolder(binding)
            }
            ViewType.VIEW_TYPE_HEADER.value -> {
                val binding: LayoutLoansHeaderBinding = LayoutLoansHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                LoansHeaderViewHolder(binding)
            }
            else -> {
                val binding: LayoutLoansItemBinding = LayoutLoansItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

                LoansItemViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (position) {
            bankOffersPosition -> {
                (holder as? BankOffersViewHolder)?.bind(loans!!.bankOffer!!)
            }
            loansHeaderPosition -> {
                (holder as? LoansHeaderViewHolder)?.bind(holder.itemView.resources.getString(R.string.my_loans))
            }
            guaranteedLoansHeaderPosition -> {
                (holder as? LoansHeaderViewHolder)?.bind(holder.itemView.resources.getString(R.string.my_guaranteed_loans))
            }
            else -> {
                val contract: Contract? =
                    if (position > guaranteedLoansHeaderPosition) {
                        loans?.guaranteedContracts?.get(position - guaranteedLoansHeaderPosition - 1)
                    } else {
                        loans?.contracts?.get(position - loansHeaderPosition - 1)
                    }
                contract?.let {
                    (holder as? LoansItemViewHolder)?.bind(contract)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        var size: Int = if (!loans?.bankOffer.isNullOrEmpty()) 1 else 0

        if (!loans?.contracts.isNullOrEmpty()) {
            size += loans!!.contracts!!.size + 1
        }

        if (!loans?.guaranteedContracts.isNullOrEmpty()) {
            size += loans!!.guaranteedContracts!!.size + 1
        }

        return size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            bankOffersPosition -> {
                ViewType.VIEW_TYPE_BANK_OFFERS.value
            }
            loansHeaderPosition -> {
                ViewType.VIEW_TYPE_HEADER.value
            }
            guaranteedLoansHeaderPosition -> {
                ViewType.VIEW_TYPE_HEADER.value
            }
            else -> {
                ViewType.VIEW_TYPE_LOANS_ITEM.value
            }
        }
    }

    override fun setItems(items: Loans?) {
        this.loans = items
        updateViewTypePositions()
        notifyDataSetChanged()
    }

    class BankOffersViewHolder(private val binding: LayoutLoansBankOfferBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(bankOffers: List<BankOffer>) {
//            binding.rvLoansBankOfferItem
        }
    }

    class LoansHeaderViewHolder(private val binding: LayoutLoansHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(headerName: String?) {
            binding.tvHeaderName.text = headerName
        }
    }

    class LoansItemViewHolder(private val binding: LayoutLoansItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contract: Contract) {
            binding.tvTitle.text = contract.name
            binding.tvLoanAmountValue.text = contract.loanAmount?.toString() ?: "0"
            binding.tvMonthlyPayAmountCurrencyType.text = "AMD"
            binding.tvMonthlyPayAmountValue.text = contract.mountlyPayAmount?.toString() ?: "0"
            binding.tvMonthlyPayAmountCurrencyType.text = "AMD"
            binding.tvPaymentDateValue.text = contract.paymentDate
        }
    }
}