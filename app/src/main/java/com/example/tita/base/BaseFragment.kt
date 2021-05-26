package com.example.tita.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!
    abstract val layoutResID: Int
    abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getFragmentBinding(inflater, container)
        return binding.root
    }

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): VB
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun performDataBinding(){
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
}