package com.staqu.staquassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.staqu.staquassignment.Model.NoAnswersData
import kotlinx.android.synthetic.main.item_subitem_list.view.*

class TagsAdapter(private var context: Context,private var noAnswersData: NoAnswersData,private var mainPosition:Int):RecyclerView.Adapter<TagsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater = LayoutInflater.from(context)
        var view:View = inflater.inflate(R.layout.item_subitem_list,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return noAnswersData.items!![mainPosition].tags!!.size
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int)
        {
            itemView.tags_name.text = noAnswersData.items!![mainPosition].tags?.get(position).toString()
        }

    }
}