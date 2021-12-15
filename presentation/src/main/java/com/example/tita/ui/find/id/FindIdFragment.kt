package com.example.tita.ui.find.id

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentFindIdBinding
import com.example.tita.ui.find.viewmodel.FindIdPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindIdFragment : UtilityBase.BaseFragment<FragmentFindIdBinding>(R.layout.fragment_find_id) {


    val viewModel : FindIdPasswordViewModel by viewModels()

    override fun FragmentFindIdBinding.onCreateView() {

    }

    override fun FragmentFindIdBinding.onViewCreated() {
        with(binding){
            backBtn.setOnClickListener {
                findNavController().navigateUp()
            }
        }
        with(viewModel){

            // TODO: 2021-12-15 메일인증
        }
    }
}