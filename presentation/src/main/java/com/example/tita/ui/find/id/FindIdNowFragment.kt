package com.example.tita.ui.find.id

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentFindIdKnowBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindIdNowFragment : UtilityBase.BaseFragment<FragmentFindIdKnowBinding>(R.layout.fragment_find_id_know) {

    override fun FragmentFindIdKnowBinding.onCreateView() {

    }

    override fun FragmentFindIdKnowBinding.onViewCreated() {
        with(binding){
            backBtn.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}