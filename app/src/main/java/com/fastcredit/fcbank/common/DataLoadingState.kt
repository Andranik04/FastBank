package com.fastcredit.fcbank.common

/**
 * Created by Sargis Khlopuzyan on 4/8/2022.
 */
sealed class DataLoadingState {
    object Loading : DataLoadingState()
    object Loaded : DataLoadingState()
    class Failure(val throwable: Throwable?) : DataLoadingState()
}
