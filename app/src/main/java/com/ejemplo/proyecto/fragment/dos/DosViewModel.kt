package com.ejemplo.proyecto.fragment.dos

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
class DosViewModel @Inject constructor(): ViewModel() {
    private val _contador = MutableStateFlow(0)
    val contador : StateFlow<Int> = _contador

    init{
        actualizarContadorDos()
    }

    fun actualizarContadorDos(){
        viewModelScope.launch {
            while(true){
                delay(1000)
                _contador.value = _contador.value + 1
                Log.i("tag", "tag fragment dos ${contador.value}")
            }
        }
    }

}