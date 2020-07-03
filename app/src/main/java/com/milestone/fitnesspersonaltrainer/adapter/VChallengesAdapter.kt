package com.milestone.fitnesspersonaltrainer.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.example.lib.Deck
import com.milestone.fitnesspersonaltrainer.R
import com.zhengsr.tablib.view.adapter.TabFlowAdapter
import com.zhengsr.tablib.view.flow.TabFlowLayout
import java.util.*


class VChallengesAdapter(private val context: Context, private val layoutHelper: LayoutHelper) : DelegateAdapter.Adapter<VChallengesAdapter.ViewHolder>() {
    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_challenges, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datas: MutableList<String> = ArrayList()
        for (i in 0..4) {
            datas.add(i.toString())
        }

        holder.hRv.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        holder.hRv.adapter = ChallengesAdapter(context, datas)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun getItemViewType(position: Int): Int {
        return 5
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hRv: RecyclerView = itemView.findViewById(R.id.horizontal_rv)
    }

}