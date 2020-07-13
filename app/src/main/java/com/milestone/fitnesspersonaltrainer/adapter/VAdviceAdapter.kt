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
import com.makeramen.roundedimageview.RoundedImageView
import com.milestone.fitnesspersonaltrainer.R
import com.milestone.fitnesspersonaltrainer.ui.activity.DetailsActivity
import com.milestone.fitnesspersonaltrainer.ui.activity.SearchActivity
import com.milestone.fitnesspersonaltrainer.widget.ItemOffsetDecoration
import com.zhengsr.tablib.view.adapter.TabFlowAdapter
import com.zhengsr.tablib.view.flow.TabFlowLayout
import java.util.*

class VAdviceAdapter(private val context: Context, private val layoutHelper: LayoutHelper) : DelegateAdapter.Adapter<RecyclerView.ViewHolder>() {

    private val FLAG_ADVICE_HEADER = 0
    private val FLAG_ADVICE_TRAINER_TIPS = 1
    private val FLAG_ADVICE_FITNESS = 2

    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            FLAG_ADVICE_HEADER -> HeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.v_advice_header, parent, false))
            FLAG_ADVICE_TRAINER_TIPS -> TrainerTipsViewHolder(LayoutInflater.from(context).inflate(R.layout.v_advice_trainer_tips, parent, false))
            FLAG_ADVICE_FITNESS -> FitnessViewHolder(LayoutInflater.from(context).inflate(R.layout.v_advice_fitness, parent, false))
            else -> HeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.v_advice_header, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is HeaderViewHolder -> {
                val datas: MutableList<String> = ArrayList()
                for (i in 0..3) {
                    datas.add(i.toString())
                }
                holder.hRv.layoutManager = LinearLayoutManager(context)
                holder.hRv.adapter = AdviceHeaderAdapter(context, datas)

                holder.cover.setOnClickListener {
                    context.startActivity(Intent(context, DetailsActivity::class.java))
                }
            }

            is TrainerTipsViewHolder -> {
                val datas: MutableList<String> = ArrayList()
                for (i in 0..4) {
                    datas.add(i.toString())
                }
                holder.hRv.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                holder.hRv.adapter = AdviceTipsAdapter(context, datas)
            }

            is FitnessViewHolder -> {
                val datas: MutableList<String> = ArrayList()
                for (i in 0..2) {
                    datas.add(i.toString())
                }
                holder.hRv.layoutManager = LinearLayoutManager(context)
                holder.hRv.adapter = AdviceFitnessAdapter(context, datas)
            }
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hRv: RecyclerView = itemView.findViewById(R.id.tips_rv)
        var cover: RoundedImageView = itemView.findViewById(R.id.cover)
    }

    inner class TrainerTipsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hRv: RecyclerView = itemView.findViewById(R.id.horizontal_rv)
    }

    inner class FitnessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hRv: RecyclerView = itemView.findViewById(R.id.fitness_rv)
    }

}