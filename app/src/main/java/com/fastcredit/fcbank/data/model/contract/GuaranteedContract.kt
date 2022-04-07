package com.fastcredit.fcbank.data.model.contract


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuaranteedContract(
    @SerialName("Id")
    val id: Int? = null,
    @SerialName("CurrencyId")
    val currencyId: String? = null,
    @SerialName("Name")
    val name: String? = null,
    @SerialName("IsOverdue")
    val isOverdue: Boolean? = null,
    @SerialName("IsAutopayEnabled")
    val isAutopayEnabled: Boolean? = null,
    @SerialName("LoanAmount")
    val loanAmount: Double? = null,
    @SerialName("MountlyPayAmount")
    val mountlyPayAmount: Double? = null,
    @SerialName("PaymentDate")
    val paymentDate: String? = null
)