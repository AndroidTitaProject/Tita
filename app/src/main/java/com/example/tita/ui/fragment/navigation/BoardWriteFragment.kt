 package com.example.tita.ui.fragment.navigation

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
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

        binding.spinnerBox.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
               if(parent?.getItemAtPosition(position).toString() == "공지게시판")
               {
                   binding.spinnerBoxSelect.visibility = VISIBLE
               }
               else
               {
                   binding.spinnerBoxSelect.visibility = INVISIBLE
               }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        val sAdapter = ArrayAdapter.createFromResource(requireContext(),R.array.board,android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerBox.setAdapter(sAdapter)

        val scAdapter = ArrayAdapter.createFromResource(requireContext(),R.array.Select_a_board,android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerBoxSelect.setAdapter(scAdapter)

        binding.fragment = this
        return binding.root
    }
}