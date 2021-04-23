package com.staqu.staquassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.staqu.staquassignment.Model.NoAnswersData
import kotlinx.android.synthetic.main.item_stackoverflow_list.view.*

class StackoverflowlistAdapter(var context: Context, var noAnswersData: NoAnswersData?):RecyclerView.Adapter<StackoverflowlistAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view:View = inflater.inflate(R.layout.item_stackoverflow_list,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return noAnswersData?.items!!.size
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int)
        {
            itemView.item_title.text = noAnswersData!!.items!!.get(position).title
            Glide.with(itemView.context).load(noAnswersData?.items?.get(position)?.owner?.profileImage).into(itemView.item_img)

            itemView.item_rc.adapter = TagsAdapter(context,noAnswersData!!,position)

        }

    }
}