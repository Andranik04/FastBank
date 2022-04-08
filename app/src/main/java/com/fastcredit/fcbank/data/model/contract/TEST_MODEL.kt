package com.fastcredit.fcbank.data.model.contract


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TEST_MODEL(
    @SerialName("name")
    val name: String,
    @SerialName("age")
    val age: Int,
    @SerialName("count")
    val count: Int
)