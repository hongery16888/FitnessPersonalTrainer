package com.milestone.fitnesspersonaltrainer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView
import com.milestone.fitnesspersonaltrainer.R


public class AreaAdapter(private val mContext: Context, private val mDataList: MutableList<String>?) : RecyclerView.Adapter<AreaAdapter.ViewHolder>() {

    private val imageUrls: MutableList<Int> = listOf(
            R.drawable.animal_bg,
            R.drawable.aquarium_bg,
            R.drawable.bear_bg,
            R.drawable.animal_bg,
            R.drawable.aquarium_bg,
            R.drawable.animal_bg
    ).toMutableList()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title?.let { it.text = mDataList?.get(position)}
        println("------------->${mDataList?.get(position)}")
    }

    override fun getItemCount(): Int = mDataList!!.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.v_area_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){
        var title: TextView? = itemView?.findViewById(R.id.title)
    }

}