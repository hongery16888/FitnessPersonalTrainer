package com.milestone.fitnesspersonaltrainer.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.example.lib.Deck
import com.milestone.fitnesspersonaltrainer.R
import com.milestone.fitnesspersonaltrainer.widget.ItemOffsetDecoration
import com.zhengsr.tablib.view.adapter.TabFlowAdapter
import com.zhengsr.tablib.view.flow.TabFlowLayout
import java.util.*

class VCommonAdapter(private val context: Context, private val layoutHelper: LayoutHelper) : DelegateAdapter.Adapter<RecyclerView.ViewHolder>() {

    private val FLAG_HEADER = 0
    private val FLAG_TRENDING = 1
    private val FLAG_UPCOMING = 2
    private val FLAG_DEMAND = 3
    private val FLAG_CHALLENGES = 4
    private val FLAG_TARGET_AREA = 5
    private val FLAG_TIME = 6
    private val FLAG_INTENSITY = 7
    private val FLAG_DAILYFIX = 8
    private val FLAG_CELEBRITY = 9
    private val FLAG_TRAINERS = 10

    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            FLAG_HEADER -> HeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_header, parent, false))
            FLAG_UPCOMING -> UpcomingViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_upcoming, parent, false))
            FLAG_TRENDING -> TrendingViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_trending, parent, false))
            FLAG_DEMAND -> DemandViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_demand, parent, false))
            FLAG_CHALLENGES -> ChallengesViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_challenges, parent, false))
            FLAG_TARGET_AREA -> AreaViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_area, parent, false))
            FLAG_TIME -> TimeViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_time, parent, false))
            FLAG_INTENSITY -> IntensityViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_intensity, parent, false))
            FLAG_DAILYFIX -> DailyFixViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_dailyfix, parent, false))
            FLAG_CELEBRITY -> CelebrityViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_celebrity, parent, false))
            FLAG_TRAINERS -> TrainersViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_trainers, parent, false))
            else -> HeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_header, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is HeaderViewHolder -> {
            }

            is UpcomingViewHolder ->{
                val datas: MutableList<String> = ArrayList()
                for (i in 0..9) {
                    datas.add(i.toString())
                }

                val lists = ArrayList<String?>()
                lists.add("05:30")
                lists.add("06:00")
                lists.add("07:00")
                lists.add("08:00")
                lists.add("08:30")
                lists.add("09:30")
                lists.add("10:30")
                lists.add("12:00")
                lists.add("13:00")
                lists.add("16:00")

                holder.tabFlow.adapter = object : TabFlowAdapter<String?>(R.layout.item_msg, lists) {
                    override fun onItemSelectState(view: View, isSelected: Boolean) {
                        super.onItemSelectState(view, isSelected)
                        //选中时，可以改变不同颜色，如果你的background 为 selector，可以不写这个
                        if (isSelected) {
                            setTextColor(view, R.id.time_text, Color.parseColor("#5191F0"))
                        } else {
                            setTextColor(view, R.id.time_text, Color.WHITE)
                        }
                    }

                    override fun bindView(view: View?, data: String?, position: Int) {
                        /**
                         * 绑定数据，可以使用 setText(..) 等快捷方式，也可以视同 view.findViewById()
                         * 同时，当你的子控件需要点击事件时，可以通过  addChildrenClick() 注册事件，
                         * 然后重写 onItemChildClick(..) 即可拿到事件，否则就自己写。
                         * 自己的点击和长按不需要注册
                         */
                        setText(view, R.id.time_text, data)
                                .setTextColor(view, R.id.time_text, Color.WHITE)

                        // 注册子控件的点击事件
                        addChildrenClick(view,R.id.time_text,position);
                        //注册子控件的长按事件
                        //addChildrenLongClick(view,R.id.time_text,position);
                    }

                    override fun onItemChildClick(childView: View?, position: Int) {
                        holder.deckPager.currentItem = position
                    }
                }

                holder.deckPager.offscreenPageLimit = 5
                holder.deckPager.adapter = UpcomingAdapter(context)

                holder.tabFlow.setTextId(R.id.time_text)
                holder.tabFlow.setUnSelectedColor(Color.parseColor("#5191F0"))
                holder.tabFlow.setSelectedColor(Color.WHITE)
                holder.tabFlow.setViewPager(holder.deckPager)
            }

            is TrendingViewHolder ->{
                val datas: MutableList<String> = ArrayList()
                for (i in 0..4) {
                    datas.add(i.toString())
                }
                holder.hRv.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                holder.hRv.adapter = TrendingAdapter(context, datas)
            }

            is DemandViewHolder -> {
                val datas: MutableList<String> = ArrayList()
                for (i in 0..10) {
                    datas.add(i.toString())
                }
                holder.hRv.layoutManager = GridLayoutManager(context, 2)
                holder.hRv.adapter = DemandAdapter(context, datas)
            }

            is ChallengesViewHolder -> {
                val datas: MutableList<String> = ArrayList()
                for (i in 0..4) {
                    datas.add(i.toString())
                }

                holder.hRv.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                holder.hRv.adapter = ChallengesAdapter(context, datas)
            }

            is AreaViewHolder -> {
                val datas: MutableList<String> = ArrayList()
                for (i in 0..5) {
                    datas.add(i.toString())
                }
                holder.hRv.layoutManager = GridLayoutManager(context, 3)
                holder.hRv.adapter = AreaAdapter(context, datas)
            }

            is TimeViewHolder -> {
            }

            is IntensityViewHolder -> {
            }

            is DailyFixViewHolder -> {
                val datas: MutableList<String> = ArrayList()
                for (i in 0..4) {
                    datas.add(i.toString())
                }
                holder.hRv.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                holder.hRv.adapter = DailyFixAdapter(context, datas)
            }

            is CelebrityViewHolder -> {
                val datas: MutableList<String> = ArrayList()
                for (i in 0..2) {
                    datas.add("Magic $i")
                }
                holder.hRv.layoutManager = GridLayoutManager(context, 4)
                holder.hRv.adapter = CelebrityAdapter(context, datas)
            }

            is TrainersViewHolder -> {

                println("----------------->onBindViewHolder : $holder")

                val datas: MutableList<String> = ArrayList()
                for (i in 0..19) {
                    datas.add("Magic $i")
                }
                holder.hRv.layoutManager = GridLayoutManager(context, 4)
                holder.hRv.adapter = TrainersAdapter(context, datas)
            }
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        println("----------------->onViewRecycled : $holder")
        when(holder){
            is TrainersViewHolder -> holder.hRv.adapter = null
        }
    }

    override fun getItemCount(): Int {
        return 11
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class UpcomingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tabFlow: TabFlowLayout = itemView.findViewById(R.id.rectflow)
        var deckPager: Deck = itemView.findViewById(R.id.deck_pager)
    }

    inner class TrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var hRv: RecyclerView = itemView.findViewById(R.id.horizontal_rv)
    }

    inner class DemandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hRv: RecyclerView = itemView.findViewById(R.id.horizontal_rv)
    }

    inner class ChallengesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hRv: RecyclerView = itemView.findViewById(R.id.horizontal_rv)
    }

    inner class AreaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hRv: RecyclerView = itemView.findViewById(R.id.grad_rv)
    }

    inner class TimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class IntensityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class DailyFixViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hRv: RecyclerView = itemView.findViewById(R.id.horizontal_rv)
    }

    inner class CelebrityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hRv: RecyclerView = itemView.findViewById(R.id.grad_rv)
    }

    inner class TrainersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hRv: RecyclerView = itemView.findViewById(R.id.grad_rv)
    }

}