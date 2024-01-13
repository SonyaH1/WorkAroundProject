package com.example.workaroundproject.somestuff

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workaroundproject.databinding.BugRecyclerViewItemBinding
import com.example.workaroundproject.databinding.CatRecyclerViewItemBinding
import com.example.workaroundproject.databinding.HumanRecyclerViewItemBinding
import com.example.workaroundproject.somestuff.data.ItemType
import com.example.workaroundproject.somestuff.data.LifeBeing
import java.lang.IllegalArgumentException

class CustomBindingRecyclerViewAdapter(
    private val actionListener: (String) -> Unit
) : RecyclerView.Adapter<LifeBeingViewHolder<out LifeBeing>>() {

    var lifeBeings = emptyList<LifeBeing>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LifeBeingViewHolder<out LifeBeing> {
        return when (viewType) {
            ItemType.ITEM_CAT.value -> {
                val binding = CatRecyclerViewItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                CatBeingViewHolder(binding)
            }

            ItemType.ITEM_HUMAN.value -> {
                val binding = HumanRecyclerViewItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                HumanBeingViewHolder(binding)
            }

            ItemType.ITEM_BUG.value -> {
                val binding = BugRecyclerViewItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                BugBeingViewHolder(binding, actionListener)
            }

            else -> {
                throw IllegalArgumentException("Invalid type $viewType")
            }

        }
    }

    override fun onBindViewHolder(holder: LifeBeingViewHolder<out LifeBeing>, position: Int) {
        when (val item = lifeBeings[position]) {
            is LifeBeing.Cat -> {
                (holder as CatBeingViewHolder).bind(item)
            }

            is LifeBeing.Human -> {
                (holder as HumanBeingViewHolder).bind(item)
            }

            is LifeBeing.Bug -> {
                (holder as BugBeingViewHolder).bind(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return lifeBeings.size
    }

    override fun getItemViewType(position: Int): Int {
        return lifeBeings[position].type.value
    }

}

internal class CatBeingViewHolder(
    private val binding: CatRecyclerViewItemBinding
) : LifeBeingViewHolder<LifeBeing.Cat>(binding.root) {

    override fun bind(item: LifeBeing.Cat) {
        with(binding) {
            name.text = item.name
            age.text = item.age.toString()
            catPicture.setImageResource(item.drawable)
        }
    }
}

internal class HumanBeingViewHolder(
    private val binding: HumanRecyclerViewItemBinding
) : LifeBeingViewHolder<LifeBeing.Human>(binding.root) {

    override fun bind(item: LifeBeing.Human) {
        with(binding) {
            name.text = item.name
            age.text = item.age.toString()
        }
    }
}

internal class BugBeingViewHolder(
    private val binding: BugRecyclerViewItemBinding,
    private val actionListener: (String) -> Unit
) : LifeBeingViewHolder<LifeBeing.Bug>(binding.root) {

    //just to know, you can get context from itemView

    override fun bind(item: LifeBeing.Bug) {

        binding.bugPicture.setOnClickListener {
            actionListener("Hello, my name is ${item.name}")
//            showToast("Hello, my name is ${item.name}")
        }
    }

//    private fun showToast(message: String){
//        Toast.makeText(itemView.context, message, Toast.LENGTH_SHORT).run {
//            show()
//        }
//    }
}

abstract class LifeBeingViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: T)
}
