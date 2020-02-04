package com.smart.sample.presentation.ui

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.compact.widget.recyclerview.CompactRecyclerView
import com.smart.sample.domain.model.Trend

class TrendAdapter : CompactRecyclerView.Adapter<Trend, TrendAdapter.ViewHolder>() {

    override fun itemDecorations(): Array<RecyclerView.ItemDecoration> {
        return arrayOf(CompactRecyclerView.SpacesItemDecoration.Linear.builder(context).first(2).build())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.simple_list_item_1,
                        parent,
                        false
                )
        )
    }

    class ViewHolder(itemView: View) : CompactRecyclerView.ViewHolder<Trend>(itemView) {
        private val name: TextView = itemView.findViewById(R.id.text1)

        override fun bind(position: Int, obj: Trend?) {
            name.text = obj?.fullName
        }
    }

}
