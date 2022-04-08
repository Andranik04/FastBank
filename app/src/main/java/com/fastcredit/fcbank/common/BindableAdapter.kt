package com.fastcredit.fcbank.common

import com.fastcredit.fcbank.common.enums.GridViewType

/**
 * Created by Sargis Khlopuzyan on 4/8/2022.
 */
interface BindableAdapter<T> {
    fun setItems(items: T?)
    fun setDataLoadingState(dataLoadingState: DataLoadingState?) {}
    fun setGridViewType(gridViewType: GridViewType?) {}
}