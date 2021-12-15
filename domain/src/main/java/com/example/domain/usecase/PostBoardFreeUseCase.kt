package com.example.domain.usecase

import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.BoardFreePost
import com.example.domain.entity.BoardFreePostEntity
import com.example.domain.repository.BoardRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PostBoardFreeUseCase @Inject constructor(private val repository: BoardRepository) :
    ParamsUseCase<PostBoardFreeUseCase.Params, Single<BoardFreePost>>() {

    data class Params(
        val postLocation : String,
        val boardFreePostEntity : BoardFreePostEntity
    )

    override suspend fun buildUseCaseObservable(params: Params): Single<BoardFreePost> {
        return repository.boardFreePost(params.postLocation,params.boardFreePostEntity)
    }
}