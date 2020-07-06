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

class VSearchAdapter(private val context: Context, private val layoutHelper: LayoutHelper) : DelegateAdapter.Adapter<RecyclerView.ViewHolder>() {

    private val FLAG_SEARCH_TIME = 0
    private val FLAG_SEARCH_INTENSITY = 1
    private val FLAG_SEARCH_TARGET_AREA = 2
    private val FLAG_SEARCH_CATEGORY = 3
    private val FLAG_SEARCH_EQUIPMENT = 4
    private val FLAG_SEARCH_TRAINERS = 5

    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            FLAG_SEARCH_TIME -> TimeViewHolder(LayoutInflater.from(context).inflate(R.layout.v_search_time, parent, false))
            FLAG_SEARCH_INTENSITY -> IntensityViewHolder(LayoutInflater.from(context).inflate(R.layout.v_search_intensity, parent, false))
            FLAG_SEARCH_TARGET_AREA -> AreaViewHolder(LayoutInflater.from(context).inflate(R.layout.v_search_target_area, parent, false))
            FLAG_SEARCH_CATEGORY -> CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.v_search_category, parent, false))
            FLAG_SEARCH_EQUIPMENT -> EquipmentViewHolder(LayoutInflater.from(context).inflate(R.layout.v_search_equipment, parent, false))
            FLAG_SEARCH_TRAINERS -> TrainersViewHolder(LayoutInflater.from(context).inflate(R.layout.v_search_trainers, parent, false))
            else -> TimeViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_header, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is TimeViewHolder -> {
            }

            is IntensityViewHolder -> {
            }

            is AreaViewHolder -> {
            }

            is CategoryViewHolder -> {
            }

            is EquipmentViewHolder -> {
            }

            is TrainersViewHolder -> {
                val datas: MutableList<String> = ArrayList()
                for (i in 0..19) {
                    datas.add("Magic $i")
                }
                holder.hRv.layoutManager = GridLayoutManager(context, 4)
                holder.hRv.adapter = TrainersAdapter(context, datas)
            }
        }
    }

    override fun getItemCount(): Int {
        return 6
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class TimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class IntensityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class AreaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class EquipmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class TrainersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hRv: RecyclerView = itemView.findViewById(R.id.grad_rv)
    }

}