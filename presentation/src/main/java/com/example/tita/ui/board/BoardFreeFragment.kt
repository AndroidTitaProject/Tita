package com.example.tita.ui.board

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentBoardBinding
import com.example.tita.databinding.FragmentBoardFreeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BoardFreeFragment :  UtilityBase.BaseFragment<FragmentBoardFreeBinding>(R.layout.fragment_board_free) {

    override fun FragmentBoardFreeBinding.onCreateView(){

    }

    override fun FragmentBoardFreeBinding.onViewCreated(){

        binding.scrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->


            if(scrollY < oldScrollY)  ObjectAnimator.ofFloat(binding.floatingButton , "translationY", 500f).apply { start() }
            else if(scrollY > oldScrollY)  ObjectAnimator.ofFloat(binding.floatingButton , "translationY", 0f).apply { start() }

        }


    }




}