package com.example.tita.ui.find.password

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
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
import com.example.tita.databinding.FragmentFindPasswordChangeBinding
import com.example.tita.databinding.FragmentFindPasswordChangeFinishBinding
import com.example.tita.ui.find.viewmodel.FindIdPasswordViewModel
import com.example.tita.utils.EventObserver
import com.example.tita.utils.errorAnimationShow
import com.example.tita.utils.successAnimationShow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.regex.Pattern

@AndroidEntryPoint
class FindPasswordFinishFragment :
    UtilityBase.BaseFragment<FragmentFindPasswordChangeFinishBinding>(R.layout.fragment_find_password_change_finish) {

    override fun FragmentFindPasswordChangeFinishBinding.onCreateView() {

    }

    override fun FragmentFindPasswordChangeFinishBinding.onViewCreated() {
        with(binding) {
            backBtn.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }


}