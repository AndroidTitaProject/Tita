package com.example.tita.ui.signup.fragment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.school.RowEntity
import com.example.domain.entity.school.SchoolInfoEntity
import com.example.domain.entity.school.SchoolResponseEntity
import com.example.domain.usecase.school.SearchSchoolUseCase
import com.example.tita.base.BaseViewModel
import com.example.tita.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolViewModel @Inject constructor(
    private val searchSchoolUseCase: SearchSchoolUseCase
) : BaseViewModel() {


    private val _schoolSearch = MutableLiveData<List<RowEntity>?>()
    val schoolSearch: LiveData<List<RowEntity>?> get() = _schoolSearch

    private val _isFailure = MutableLiveData<Event<String>>()
    val isFailure: LiveData<Event<String>> = _isFailure

    fun searchSchool(
        schoolName: String,
    ) = viewModelScope.launch {
        try {
            addDisposable(
                searchSchoolUseCase.buildUseCaseObservable(
                    SearchSchoolUseCase.Params(
                        schoolName,
                        "json",
                        "1",
                        "100",
                        ""
                    )
                )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->

                        Log.d("TAG", "searchSchool: ${listOf(response)}")
                        response.schoolInfoEntity.map { data ->
                            Log.d("TAG", "rowData: ${data.row}")
                            data.row?.filter {
                                it.sCHULNM?.contains("고등학교") == true
                            }.apply {
                                _schoolSearch.value = this

                            }
                        }
                        Log.d("TAG", " _schoolSearch.value: ${_schoolSearch.value}")

                    }, {
                        Log.d("TAG", "searchSchool: fail ${it.message} ")
                        _isFailure.value = Event(it.message ?: "")
                    })
            )
        } catch (e: Exception) {
            Log.e("TAG", "searchSchool:  searchSchool ${e}")
            _isFailure.value = Event(e.message ?: "")
        }

    }
}