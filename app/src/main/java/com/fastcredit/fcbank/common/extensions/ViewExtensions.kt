package com.fastcredit.fcbank.common.extensions

import android.view.View
import android.view.View.*

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */

fun View.setVisibleOrGone(show: Boolean) {
    visibility = if (show) VISIBLE else GONE
}

fun View.setVisibleOrInvisible(show: Boolean) {
    visibility = if (show) VISIBLE else INVISIBLE
}