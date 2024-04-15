package com.example.newsapp.presentation.favourite

import com.example.newsapp.domain.model.Article

data class FavouriteState(
    val articles :List<Article> = emptyList()
)
