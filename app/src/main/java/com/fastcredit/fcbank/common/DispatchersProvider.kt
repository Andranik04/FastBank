package com.fastcredit.fcbank.common

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
open class DispatchersProvider() {
    open val Main: CoroutineContext by lazy { Dispatchers.Main }
    open val IO: CoroutineContext by lazy { Dispatchers.IO }
}