package com.example.tita.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.school.RowEntity
import com.example.tita.R
import com.example.tita.databinding.SearchSchoolItemBinding
import com.example.tita.utils.RecyclerViewItemClickListener

class SearchSchoolAdapter(val onClickListener: RecyclerViewItemClickListener<RowEntity>) : RecyclerView.Adapter<SearchSchoolAdapter.SearchSchoolHolder>() {

    private var searchList = mutableListOf<RowEntity>()

    class SearchSchoolHolder(val binding: SearchSchoolItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(bind: RowEntity) {
            Log.d("TAG", "sCHULNM: ${bind.sCHULNM}")
            binding.data= bind
            binding.executePendingBindings( )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSchoolHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<SearchSchoolItemBinding>(
            layoutInflater,
            R.layout.search_school_item,
            parent,
            false
        )

        return SearchSchoolHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchSchoolHolder, position: Int) {
        holder.bind(searchList[position])
        holder.itemView.setOnClickListener{
            onClickListener.onclick(searchList[position])
        }

    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    fun setData(data: List<RowEntity>) {

        Log.d("TAG", "setData: ${data}")
        val diffUtil = SearchSchoolDiffUtil(searchList, (data))
        val diffUtilResult = diffUtil.let { DiffUtil.calculateDiff(it) }
        searchList = (data).toMutableList()
        diffUtilResult.dispatchUpdatesTo(this)
    }
    class SearchSchoolDiffUtil(
        private val oldList: List<RowEntity>,
        private val newList: List<RowEntity>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] === newList[newItemPosition]


        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] === newList[newItemPosition]


        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]

            return getChangePayload(
                oldItemPosition,
                newItemPosition
            )
        }
    }
}