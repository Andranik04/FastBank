package com.fastcredit.fcbank.common.enums

/**
 * Created by Sargis Khlopuzyan on 4/8/2022.
 */
enum class GridViewType {
    Linear, Grid;

    companion object {
        fun getViewType(name: String): GridViewType {
            return when (name) {
                Linear.name -> Linear
                else -> Grid
            }
        }
    }
}