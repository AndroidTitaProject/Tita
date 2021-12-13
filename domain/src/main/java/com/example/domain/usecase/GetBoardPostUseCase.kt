package com.example.domain.usecase

import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.BoardEntity
import com.example.domain.repository.BoardRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetBoardPostUseCase @Inject constructor(private val repository: BoardRepository) :
    ParamsUseCase<GetBoardPostUseCase.Params, Single<BoardEntity>>() {

    data class Params(
       val postLocation : String
    )

    override suspend fun buildUseCaseObservable(params: Params): Single<BoardEntity> {
        return repository.getPost(params.postLocation)
    }
}