package com.example.tita.ui.board

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentBoardBinding
import com.example.tita.databinding.FragmentFindPasswordChangeBinding
import com.example.tita.databinding.FragmentSignUpCertificatioSchoolBinding
import com.example.tita.ui.findidpassword.fragment.viewmodel.FindIdPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class BoardFragment : UtilityBase.BaseFragment<FragmentBoardBinding>(R.layout.fragment_board) {

    private val viewModel by activityViewModels<BoardViewmodel>()

    override fun FragmentBoardBinding.onCreateView(){

    }

    override fun FragmentBoardBinding.onViewCreated(){

        binding.freeBoardArea.setOnClickListener {
            this@BoardFragment.findNavController()
                .navigate(R.id.action_homeboardFragment_to_boardFreeFragment)

        }

        binding.noticeBoardArea.setOnClickListener {
            this@BoardFragment.findNavController()
                .navigate(R.id.action_homeboardFragment_to_boardNoticeMenuFragment)
        }
    }

}