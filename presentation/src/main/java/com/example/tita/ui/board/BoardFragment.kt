package com.example.tita.ui.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentBoardBinding
import com.example.tita.databinding.FragmentFindPasswordChangeBinding
import com.example.tita.databinding.FragmentSignUpCertificatioSchoolBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BoardFragment : UtilityBase.BaseFragment<FragmentBoardBinding>(R.layout.fragment_board) {

    override fun FragmentBoardBinding.onCreateView(){

    }

    override fun FragmentBoardBinding.onViewCreated(){

        binding.freeBoardArea.setOnClickListener {  findNavController().navigate(R.id.action_boardFragment_to_boardFreeFragment)  }

        binding.noticeBoardArea.setOnClickListener {  }
    }

}