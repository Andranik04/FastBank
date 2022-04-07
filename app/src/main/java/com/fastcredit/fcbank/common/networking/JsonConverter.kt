package com.fastcredit.fcbank.common.networking

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

/**
 * Created by Sargis Khlopuzyan on 4/7/2022.
 */
class JsonConverter {
    companion object {
        inline fun <reified T : Any> jsonToObject(jsonString: String?): T? {
            return try {
                Gson().fromJson(jsonString, T::class.java)
            } catch (e: JsonSyntaxException) {
                null
            }
        }
    }
}