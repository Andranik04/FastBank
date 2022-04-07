package com.fastcredit.fcbank.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 */
open class BaseViewModel : ViewModel() {

    private val _navigationFlow = MutableSharedFlow<Screen>()
    val navigationSharedFlow = _navigationFlow.asSharedFlow()

    fun navigateTo(screen: Screen) {
        viewModelScope.launch {
            _navigationFlow.emit(screen)
        }
    }
    
}