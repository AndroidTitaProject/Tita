package com.example.tita.ui.board

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.core.view.get
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentBoardBinding
import com.example.tita.databinding.FragmentBoardFreeBinding
import com.example.tita.ui.board.adapter.BoardAdapter
import com.example.tita.ui.findidpassword.fragment.viewmodel.FindIdPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class BoardFreeFragment :  UtilityBase.BaseFragment<FragmentBoardFreeBinding>(R.layout.fragment_board_free) {

    private val viewModel by activityViewModels<BoardViewmodel>()

    // TODO: 글쓰기 및 게시물 확인 만들기

    override fun FragmentBoardFreeBinding.onCreateView(){

    }

    override fun FragmentBoardFreeBinding.onViewCreated(){

        binding.floatingButton.setOnClickListener { onClickFloatingButton() }

        binding.backButton.setOnClickListener {   this@BoardFreeFragment.findNavController().popBackStack()}

        setFloatingButton()

        setObserve()

        viewModel.setisSuccessBoard()

        lifecycleScope.launch{
            viewModel.getPost("자유게시판")
        }

    }

    private fun setObserve() {
        viewModel.boardData.observe(viewLifecycleOwner,{
            Log.d("dsaf",it.toString())
            binding.recyclerview.adapter = BoardAdapter(it,viewModel)
            binding.recyclerview.layoutManager = LinearLayoutManager(requireContext(),
                RecyclerView.VERTICAL,false)
        })
    }

    private fun setFloatingButton() {
        val onScrollListener = object:RecyclerView.OnScrollListener() {
            var temp: Int = 0
            override fun onScrolled(@NonNull recyclerView:RecyclerView, dx:Int, dy:Int) {
                if(temp == 1) {
                    super.onScrolled(recyclerView, dx, dy)
                    ObjectAnimator.ofFloat(binding.floatingButton , "translationY", 500f).apply { start() }
                }
            }
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                ObjectAnimator.ofFloat(binding.floatingButton , "translationY", 0f).apply { start() }
                temp = 1
            }
        }

        binding.recyclerview?.setOnScrollListener(onScrollListener)
    }

    private fun onClickFloatingButton(){
        this@BoardFreeFragment.findNavController()
            .navigate(R.id.action_boardFreeFragment_to_boardWriteFragment)
    }


}