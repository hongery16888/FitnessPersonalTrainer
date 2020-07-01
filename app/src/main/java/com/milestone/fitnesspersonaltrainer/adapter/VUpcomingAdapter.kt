package com.milestone.fitnesspersonaltrainer.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.example.lib.Deck
import com.milestone.fitnesspersonaltrainer.R
import com.zhengsr.tablib.view.adapter.TabFlowAdapter
import com.zhengsr.tablib.view.flow.TabFlowLayout
import java.util.*


class VUpcomingAdapter(private val context: Context, private val layoutHelper: LayoutHelper) : DelegateAdapter.Adapter<VUpcomingAdapter.ViewHolder>() {
    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.v_main_upcoming, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
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

    override fun getItemCount(): Int {
        return 1
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var datePicker: DatePickerTimeline = itemView.findViewById(R.id.datePickerTimeline)
        var tabFlow: TabFlowLayout = itemView.findViewById(R.id.rectflow)
        var deckPager: Deck = itemView.findViewById(R.id.deck_pager)
    }

}