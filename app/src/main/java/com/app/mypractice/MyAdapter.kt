package com.app.mypractice

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_item.view.*

class MyAdapter(var items: List<Item>, private val listener: (Item) -> Unit) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    //======================================

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //-------------------------------------OR----------------------------

    /* override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
         ViewHolder(parent.inflate(R.layout.view_item))

     override fun onBindViewHolder(holder: ViewHolder, position: Int) =
         holder.bind(items[position], listener)

     override fun getItemCount() = items.size */


    //===========================================================

    //View Holder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {
            textView.text = item.title
            imageView.loadUrl(item.url)
            setOnClickListener { listener(item) }
        }
    }
}