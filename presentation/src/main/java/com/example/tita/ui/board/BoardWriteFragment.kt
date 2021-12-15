package com.example.tita.ui.board

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentBoardFreeBinding
import com.example.tita.databinding.FragmentBoardWriteBinding
import com.example.tita.ui.board.adapter.BoardAdapter
import kotlinx.coroutines.launch

class BoardWriteFragment : UtilityBase.BaseFragment<FragmentBoardWriteBinding>(R.layout.fragment_board_write){

    private val viewModel by activityViewModels<BoardViewmodel>()

    override fun FragmentBoardWriteBinding.onCreateView(){

    }

    override fun FragmentBoardWriteBinding.onViewCreated(){

            setUpSpinner()

            binding.inputButton.setOnClickListener { boardPost() }

            viewModel.isSuccess.observe(viewLifecycleOwner,{
            Log.d("dsaf",it.toString())
             this@BoardWriteFragment.findNavController()
                    .navigate(R.id.action_boardWriteFragment_to_boardFreeFragment)
        })

        }

    private fun setUpSpinner() {
        binding.spinnerBox.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position){
                    0 -> {
                        viewModel.setBoardPosition("자유게시판")
                        binding.spinnerBoxSelect.visibility = View.INVISIBLE
                    }
                    1 ->{
                        binding.spinnerBoxSelect.visibility = View.VISIBLE
                        setUpNoticeSpinner()
                    }
                }
            }
        }
    }

    fun boardPost(){

        if(TextUtils.isEmpty(binding.titleTextview.text) && TextUtils.isEmpty(binding.contentTextview.text)){
            Toast.makeText(activity,"모든 칸을 채워주세요",Toast.LENGTH_SHORT).show()
            }
        else if(TextUtils.isEmpty(binding.titleTextview.text) || TextUtils.isEmpty(binding.contentTextview.text)){
            Toast.makeText(activity,"모든 칸을 채워주세요",Toast.LENGTH_SHORT).show()
        }
        else{
            lifecycleScope.launch{
                viewModel.postBoardFree(viewModel.boardPosition.toString(),binding.titleTextview.text.toString(),binding.contentTextview.text.toString())
            }
        }
    }

    fun setUpNoticeSpinner(){
        binding.spinnerBoxSelect.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                when(position){
                    0 -> viewModel.setBoardPosition("학생회")
                    1 -> viewModel.setBoardPosition("기숙사자치위원회")
                    2 -> viewModel.setBoardPosition("전공동아리")
                    3 -> viewModel.setBoardPosition("자율동아리")
                    4 -> viewModel.setBoardPosition("창체동아리")
                }

            }
        }
    }

}