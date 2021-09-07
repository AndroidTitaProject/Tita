package com.example.domain.base

abstract class BaseUseCase<out T> {
    abstract fun buildUseCaseObservable(): T
}