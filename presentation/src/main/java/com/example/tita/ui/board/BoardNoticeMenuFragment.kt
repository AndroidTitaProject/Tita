package com.example.tita.ui.board

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentBoardNoticeBinding
import com.example.tita.databinding.FragmentBoardNoticeMenuBinding

class BoardNoticeMenuFragment : UtilityBase.BaseFragment<FragmentBoardNoticeMenuBinding>(R.layout.fragment_board_notice_menu) {


    private val viewModel by activityViewModels<BoardViewmodel>()


    override fun FragmentBoardNoticeMenuBinding.onCreateView(){

    }

    override fun FragmentBoardNoticeMenuBinding.onViewCreated(){
        binding.onClickBoard = this@BoardNoticeMenuFragment
    }

    fun getNoticeBoardPosition(v : View){

        when(v.id){
            binding.linearLayout4.id -> viewModel.setNoticeBoard("학생회 게시판")
            binding.linearLayout5.id -> viewModel.setNoticeBoard("기숙사자치위원회 게시판")
            binding.linearLayout6.id -> viewModel.setNoticeBoard("전공동아리 게시판")
            binding.linearLayout7.id -> viewModel.setNoticeBoard("창체동아리 게시판")
            binding.linearLayout8.id -> viewModel.setNoticeBoard("자율동아리 게시판")
        }

        this@BoardNoticeMenuFragment.findNavController()
            .navigate(R.id.action_boardNoticeMenuFragment_to_boardNoticeFragment)
    }

}