package com.ejemplo.proyecto.fragment.uno

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnoViewModel @Inject constructor(): ViewModel() {
    private val _contador = MutableStateFlow(0)
    val contador : StateFlow<Int> = _contador

    init{
        actualizarContadorUno()
    }

    fun actualizarContadorUno(){
        viewModelScope.launch {
            while(true){
                delay(1000)
                _contador.value = _contador.value + 1
                Log.i("tag", "tag fragment uno ${contador.value}")
            }
        }
    }
}