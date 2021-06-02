package com.example.tita.ui.fragment.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.tita.R
import com.example.tita.databinding.FragmentBoardBinding
import com.example.tita.databinding.FragmentBoardWriteBinding

class BoardWriteFragment : Fragment() {
    lateinit var binding: FragmentBoardWriteBinding
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_board_write, container, false)

        binding.fragment = this
        return binding.root

    }
}