package com.example.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        "News Every Time",
        "Be Aware of what is happening now",
        R.drawable.onboard1
    ),
    Page(
        "Different Sources",
        " see different source of truth",
        R.drawable.onboard2
    ),
    Page(
        "All type of News",
        "You can find more than you expect",
        R.drawable.onboard3
    )
)