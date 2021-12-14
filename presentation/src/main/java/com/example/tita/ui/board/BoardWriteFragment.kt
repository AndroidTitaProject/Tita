package com.example.tita.ui.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentBoardFreeBinding
import com.example.tita.databinding.FragmentBoardWriteBinding
import kotlinx.coroutines.launch

class BoardWriteFragment : UtilityBase.BaseFragment<FragmentBoardWriteBinding>(R.layout.fragment_board_write){

    override fun FragmentBoardWriteBinding.onCreateView(){

    }

    override fun FragmentBoardWriteBinding.onViewCreated(){

            setUpSpinner()

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
                        binding.spinnerBoxSelect.visibility = View.INVISIBLE
                    }
                    1 ->{
                        binding.spinnerBoxSelect.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

}