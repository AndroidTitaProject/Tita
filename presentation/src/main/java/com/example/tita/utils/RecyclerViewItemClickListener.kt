package com.example.tita.utils

interface RecyclerViewItemClickListener<T> {
    fun onclick(data: T): Unit
}