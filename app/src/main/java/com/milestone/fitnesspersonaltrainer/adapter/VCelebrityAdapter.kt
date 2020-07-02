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


class VCelebrityAdapter(private val context: Context, private val layoutHelper: LayoutHelper) : DelegateAdapter.Adapter<VCelebrityAdapter.ViewHolder>() {
    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_celebrity, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datas: MutableList<String> = ArrayList()
        for (i in 0..2) {
            datas.add("Magic $i")
        }
        holder.hRv.layoutManager = GridLayoutManager(context, 4)
        holder.hRv.addItemDecoration(ItemOffsetDecoration(context, R.dimen.dp_5))
        holder.hRv.adapter = CelebrityAdapter(context, datas)
    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hRv: RecyclerView = itemView.findViewById(R.id.grad_rv)
    }

}