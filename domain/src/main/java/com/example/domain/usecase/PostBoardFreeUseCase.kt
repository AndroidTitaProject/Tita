package com.example.domain.usecase

import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.BoardFreePost
import com.example.domain.entity.BoardFreePostEntity
import com.example.domain.entity.LoginEntity
import com.example.domain.repository.BoardFreePostRepository
import com.example.domain.repository.LoginRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PostBoardFreeUseCase @Inject constructor(private val repository: BoardFreePostRepository) :
    ParamsUseCase<PostBoardFreeUseCase.Params, Single<BoardFreePost>>() {

    data class Params(
        val postLocation : String,
        val boardFreePostEntity : BoardFreePostEntity
    )

    override suspend fun buildUseCaseObservable(params: Params): Single<BoardFreePost> {
        return repository.boardFreePost(params.postLocation,params.boardFreePostEntity)
    }
}