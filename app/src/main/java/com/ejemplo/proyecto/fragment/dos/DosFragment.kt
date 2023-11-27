package com.ejemplo.proyecto.fragment.dos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ejemplo.proyecto.databinding.FragmentDosBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DosFragment : Fragment() {
    private lateinit var dosBinding: FragmentDosBinding
    private val dosViewModel: DosViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dosBinding = FragmentDosBinding.inflate(inflater, container, false)
        return dosBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dosBinding.btnIrAFTres.setOnClickListener {
            findNavController().navigate(DosFragmentDirections.actionDosFragmentToTresFragment())
        }
        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            launch {
                dosViewModel.contador.collect {
                    dosBinding.contador.text = "Contador Fragment Dos\n$it"
                }
            }
        }
    }
}