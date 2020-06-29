package com.milestone.fitnesspersonaltrainer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.example.lib.Deck
import com.milestone.fitnesspersonaltrainer.R
import java.util.*

class VUpcomingAdapter(private val context: Context, private val layoutHelper: LayoutHelper) : DelegateAdapter.Adapter<VUpcomingAdapter.ViewHolder>() {
    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_upcoming, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("----------->Position : $position")
        val datas: MutableList<String> = ArrayList()
        for (i in 0..4) {
            datas.add(i.toString())
        }

        holder.deckPager.offscreenPageLimit = 5
        holder.deckPager.adapter = UpcomingAdapter(context)
    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var deckPager: Deck = itemView.findViewById(R.id.deck_pager)
    }

}