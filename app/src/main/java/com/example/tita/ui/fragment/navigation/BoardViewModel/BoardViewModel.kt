package com.example.tita.ui.fragment.navigation.BoardViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tita.Resource
import com.example.tita.data.network.dto.BoardData
import com.example.tita.data.repository.BoardRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class BoardViewModel@Inject constructor(
    private val boardRepository: BoardRemoteRepository
) : ViewModel() {

    //게시판의 post 요청을 하기위해 불러온 BoardData
    private var _postBoard = MutableLiveData<Resource<BoardData>>()
    val postBoard : LiveData<Resource<BoardData>> get() = _postBoard

    //먼저 false 로 지정해준 서버통신오류여부
    private var _errorLogin = MutableLiveData<Boolean>(false)
    val errorLogin: LiveData<Boolean> get() = _errorLogin

    suspend fun checkPostBoard(board: String,boardDetail: String,title : String, contents: String) = viewModelScope.launch(Dispatchers.IO) {
        //값을 넣어주고 리소스에서 확인절차를 거침
        _postBoard.postValue(Resource.Loading())
        try {
            boardRepository.postBoard(board, boardDetail,title,contents).let { response ->
                if (response.isSuccessful) {
                    response.body()?.let { _postBoard.postValue(Resource.Success(it)) }
                    Log.d(TAG, "Post succeed ")
                    _errorLogin.value = true
                }
            }
        } catch (e: KotlinNullPointerException) {
            _postBoard.postValue(Resource.Error("서버 에러"))
        }
    }

    companion object {
        val TAG = "BoardViewModel"
    }
}