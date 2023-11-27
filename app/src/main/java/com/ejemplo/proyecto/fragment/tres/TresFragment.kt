package com.ejemplo.proyecto.fragment.tres

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ejemplo.proyecto.databinding.FragmentTresBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TresFragment : Fragment() {
    private lateinit var tresBinding: FragmentTresBinding
    private val tresViewModel: TresViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tresBinding = FragmentTresBinding.inflate(inflater, container, false)
        return tresBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            launch {
                repeatOnLifecycle(Lifecycle.State.STARTED){
                    launch {
                        tresViewModel.contador.collect {
                            tresBinding.contador.text = "Contador Fragment Tres\n$it"
                        }
                    }
                }
            }
        }
    }
}