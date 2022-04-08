package com.fastcredit.fcbank.data.model.contract


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Loans(

    @SerialName("BankOffer")
    val bankOffer: List<BankOffer>? = null,

    @SerialName("Contracts")
    val contracts: List<Contract>? = null,

    @SerialName("GuaranteedContracts")
    val guaranteedContracts: List<Contract>? = null,

    @SerialName("ResultCode")
    val resultCode: Int? = null,

    @SerialName("ResultMessage")
    val resultMessage: String? = null
)