package com.fastcredit.fcbank.common.networking

import java.io.IOException

/**
 * Created by Sargis Khlopuzyan on 4/7/2022.
 */
class NoConnectivityException : IOException() {
    override val message: String
        get() = "No Internet connection"
}