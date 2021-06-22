package com.meupet.whatdidilearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.meupet.whatdidilearn.R
import com.meupet.whatdidilearn.data.LearnedItem

class LearnItemAdapter : Adapter<LearnItemAdapter.LearnedItemViewHolder>() {
    inner class LearnedItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleContainer = itemView.findViewById<TextView>(R.id.textTitulo)
        val title = itemView.findViewById<TextView>(R.id.textDes)
        val cor =itemView.findViewById<View>(R.id.view)
        fun bind(learnedItem: LearnedItem) {
            titleContainer.text = learnedItem.name
            title.text = learnedItem.description
            cor.setBackgroundResource(learnedItem.understandingLevel.color)

        }
    }

    var learnedItem = listOf<LearnedItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.learned_item,parent,false)

         return  LearnedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: LearnedItemViewHolder, position: Int) {
        val learnedItem =learnedItem[position]
        holder.bind(learnedItem)

    }

    override fun getItemCount(): Int {
        return learnedItem.size
    }
}