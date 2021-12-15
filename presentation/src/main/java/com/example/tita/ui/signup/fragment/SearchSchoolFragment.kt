package com.example.tita.ui.signup.fragment

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entity.school.RowEntity
import com.example.tita.R
import com.example.tita.adapter.SearchSchoolAdapter
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSearchSchoolBinding
import com.example.tita.ui.signup.viewmodel.SchoolViewModel
import com.example.tita.utils.RecyclerViewItemClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchSchoolFragment :
    UtilityBase.BaseFragment<FragmentSearchSchoolBinding>(R.layout.fragment_search_school),
    RecyclerViewItemClickListener<RowEntity> {

    private val searchSchoolAdapter: SearchSchoolAdapter by lazy {
        SearchSchoolAdapter(this)
    }

    private val viewModel: SchoolViewModel by viewModels()
    override fun FragmentSearchSchoolBinding.onCreateView() {
        setAdapter()
    }

    override fun FragmentSearchSchoolBinding.onViewCreated() {

        with(viewModel) {
            with(binding) {
                searchBtn.setOnClickListener {
                    lifecycleScope.launch {
                        searchSchool(searchEdit.text.toString().trim())
                    }
                }
                schoolSearch.observe(viewLifecycleOwner) {
                    Log.d("TAG", "onViewCreated: ${it}")
                    if (it != null) {
                        searchSchoolAdapter.setData((it))

                    }
                }
                backBtn.setOnClickListener {
                    findNavController().navigateUp()
                }
            }
        }
    }

    fun setAdapter() {
        binding.searchRecycler.adapter = searchSchoolAdapter
        binding.searchRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun onclick(data: RowEntity) {
        val action =
            SearchSchoolFragmentDirections.actionSearchSchoolFragmentToSignUpCertificatioSchoolFragment(
                data.sCHULNM.toString()
            )
        findNavController().navigate(action)
    }


}