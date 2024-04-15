package com.example.newsapp.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.example.newsapp.domain.model.Article
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.newsapp.presentation.shared.ArticlesList
import com.example.newsapp.presentation.shared.SearchBar

@Composable
fun  HomeScreen(
    articles:LazyPagingItems<Article>,
    navigateToSearch:()->Unit,
    navigateToDetails:(Article)->Unit
){
     Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = MediumPadding1)
        .statusBarsPadding()
    ) {
        SearchBar(
            text = "",
            readOnly = true,
            onValueChange = {},
            onCLick = {
                      navigateToSearch()
            },
            onSearch = { },
            modifier = Modifier.padding(horizontal = MediumPadding1)
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        
        ArticlesList(
            articles = articles,
            onClick = {
                navigateToDetails(it)
            },
            modifier = Modifier.padding(horizontal = MediumPadding1)
        )
    }
}