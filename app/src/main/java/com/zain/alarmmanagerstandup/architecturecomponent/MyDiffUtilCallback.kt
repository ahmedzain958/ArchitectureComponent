package com.zain.alarmmanagerstandup.architecturecomponent

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtilCallback(
    private val oldList: List<Note>,
    private val newList: List<Note>
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return oldPosition == newPosition
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return oldList[oldPosition] == newList[newPosition]
    }

}