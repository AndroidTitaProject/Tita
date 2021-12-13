package com.example.tita.ui.board.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.BoardData
import com.example.tita.R
import com.example.tita.databinding.BoardFreeRowBinding
import dagger.hilt.android.lifecycle.HiltViewModel

class BoardAdapter(board : List<BoardData>) : RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {

    var boardList = board

    inner class BoardViewHolder(val binding: BoardFreeRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(boardData: BoardData){
            binding.contentTextview.text = boardData.content
            binding.titleTextview.text = boardData.postName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val binding = BoardFreeRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        Log.d("dsaffs",boardList.toString())
        return BoardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(boardList[position])
    }

    override fun getItemCount(): Int {
        return boardList.size
    }
}