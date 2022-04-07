package com.fastcredit.fcbank.data.model.contract


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BankOffer(
    @SerialName("Image")
    val image: String? = null,
    @SerialName("Title")
    val title: String? = null,
    @SerialName("Description")
    val description: String? = null
)