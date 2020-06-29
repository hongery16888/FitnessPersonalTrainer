package com.milestone.fitnesspersonaltrainer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import com.milestone.fitnesspersonaltrainer.R
import com.milestone.fitnesspersonaltrainer.model.genCards
import www.linwg.org.lib.LCardView

class UpcomingAdapter(private val context: Context) : PagerAdapter() {

    private val cards by lazy { genCards() }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.v_upcoming_item, null)
        container.addView(view, 0)
//        view.findViewById<LCardView>(R.id.card).cardBackgroundColor = cards[position].color
//        view.findViewById<CardView>(R.id.card).cardBackgroundColor =
//                ContextCompat.getColorStateList(context, cards[position].color)
        view.findViewById<TextView>(R.id.title).text = cards[position].name
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun getCount(): Int = cards.size
}