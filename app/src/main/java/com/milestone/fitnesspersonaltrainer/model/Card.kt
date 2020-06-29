package com.milestone.fitnesspersonaltrainer.model

import com.milestone.fitnesspersonaltrainer.R

data class Card(
        val name: String,
        val color: Int
)

fun Any?.genCards() : List<Card> = listOf(
        Card("Blue Card", R.color.blue),
        Card("Red Card", R.color.red),
        Card("Green Card", R.color.green),
        Card("Yellow Card", R.color.yellow)
)