package com.smart.github.ui.trend

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.compact.widget.CompactRecyclerView
import com.smart.github.domain.model.Trend

class TrendAdapter : CompactRecyclerView.Adapter<Trend, TrendAdapter.ViewHolder>() {

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
        private val name: TextView = itemView.findViewById(android.R.id.text1)

        override fun bind(position: Int, obj: Trend?) {
            name.text = obj?.fullName
        }

    }

}
