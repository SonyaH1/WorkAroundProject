package com.example.workaroundproject.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.workaroundproject.databinding.NoteItemBinding
import com.example.workaroundproject.room.domain.entities.NoteItem

class NotesAdapter(
    private val actionListener: (Int) -> Unit,
): ListAdapter<NoteItem, NotesAdapter.ProductViewHolder>(
    object : DiffUtil.ItemCallback<NoteItem>() {
        override fun areItemsTheSame(oldItem: NoteItem, newItem: NoteItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteItem, newItem: NoteItem): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductViewHolder(
            NoteItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    inner class ProductViewHolder(private val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: NoteItem) {
            with(binding) {
                name.text = item.name
                description.text = item.description
                deleteIcon.setOnClickListener {
                    actionListener.invoke(item.id)
                }
            }
        }
    }
}