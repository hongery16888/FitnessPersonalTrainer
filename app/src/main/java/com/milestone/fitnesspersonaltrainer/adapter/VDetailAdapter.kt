package com.milestone.fitnesspersonaltrainer.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.example.lib.Deck
import com.milestone.fitnesspersonaltrainer.R
import com.milestone.fitnesspersonaltrainer.ui.activity.SearchActivity
import com.milestone.fitnesspersonaltrainer.widget.ItemOffsetDecoration
import com.zhengsr.tablib.view.adapter.TabFlowAdapter
import com.zhengsr.tablib.view.flow.TabFlowLayout
import java.util.*

class VDetailAdapter(private val context: Context, private val layoutHelper: LayoutHelper) : DelegateAdapter.Adapter<RecyclerView.ViewHolder>() {

    private val FLAG_DETAIL_INFO = 0
    private val FLAG_DETAIL_RELATED = 1

    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            FLAG_DETAIL_INFO -> InfoViewHolder(LayoutInflater.from(context).inflate(R.layout.v_detail_info, parent, false))
            FLAG_DETAIL_RELATED -> RelatedViewHolder(LayoutInflater.from(context).inflate(R.layout.v_detail_related, parent, false))
            else -> InfoViewHolder(LayoutInflater.from(context).inflate(R.layout.v_detail_info, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is InfoViewHolder -> {

            }

            is RelatedViewHolder -> {
                val datas: MutableList<String> = ArrayList()
                for (i in 0..4) {
                    datas.add(i.toString())
                }
                holder.hRv.layoutManager = LinearLayoutManager(context)
                holder.hRv.adapter = DetailRelatedAdapter(context, datas)
            }

        }
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class RelatedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hRv: RecyclerView = itemView.findViewById(R.id.horizontal_rv)
    }

}