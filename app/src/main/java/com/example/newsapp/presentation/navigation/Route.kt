package com.example.newsapp.presentation.navigation

sealed class Route(
    val route :String
) {
    object AppStartNavigation: Route("appStartNavigation")
    object OnBoardingScreen: Route("onBoardingScreen")
    object HomeScreen: Route("homeScreen")
    object DetailsScreen: Route("detailsScreen")
    object NewsNavigation: Route("newsNavigation")
    object NewsNavigatorScreen: Route("newsNavigatorScreen")
    object SearchScreen: Route("searchScreen")
    object FavoritesScreen: Route("favoritesScreen")
}