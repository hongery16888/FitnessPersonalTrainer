package com.milestone.fitnesspersonaltrainer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.milestone.fitnesspersonaltrainer.R
import com.milestone.fitnesspersonaltrainer.widget.ItemOffsetDecoration
import java.util.*


class VTimeAdapter(private val context: Context, private val layoutHelper: LayoutHelper) : DelegateAdapter.Adapter<VTimeAdapter.ViewHolder>() {
    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_time, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datas: MutableList<String> = ArrayList()
        for (i in 0..5) {
            datas.add(i.toString())
        }
    }

    override fun getItemCount(): Int {
        return 1
    }

//    override fun getItemViewType(position: Int): Int {
//        return 7
//    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}