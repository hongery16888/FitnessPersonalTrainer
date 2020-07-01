package com.milestone.fitnesspersonaltrainer.model

import android.graphics.Color
import com.milestone.fitnesspersonaltrainer.R

data class Card(
        val name: String,
        val color: Int
)

fun Any?.genCards(): List<Card> = listOf(
        Card("BLUE Card", Color.BLUE),
        Card("RED Card", Color.RED),
        Card("GREEN Card", Color.GREEN),
        Card("YELLOW Card", Color.YELLOW),
        Card("GRAY Card", Color.GRAY),
        Card("BLUE Card", Color.BLUE),
        Card("LTGRAY Card", Color.LTGRAY),
        Card("MAGENTA Card", Color.MAGENTA),
        Card("DKGRAY Card", Color.DKGRAY),
        Card("TRANSPARENT Card", Color.TRANSPARENT)
)