package com.ejemplo.proyecto.fragment.uno

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.ejemplo.proyecto.R
import com.ejemplo.proyecto.databinding.FragmentUnoBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UnoFragment : Fragment() {
    private lateinit var unoBinding: FragmentUnoBinding
    private val unoViewModel: UnoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        unoBinding = FragmentUnoBinding.inflate(inflater, container, false)
        return unoBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        unoBinding.btnIrAFDos.setOnClickListener {
            findNavController().navigate(UnoFragmentDirections.actionUnoFragmentToDosFragment())
        }
        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    unoViewModel.contador.collect{
                        unoBinding.contador.text = "Contador Fragment Uno\n$it"
                    }
                }
            }
        }
    }
}