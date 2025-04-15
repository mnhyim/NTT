package com.mnhyim.nexmediatechtest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mnhyim.nexmediatechtest.ui.feature.detail.Detail
import com.mnhyim.nexmediatechtest.ui.feature.favorites.Favorites
import com.mnhyim.nexmediatechtest.ui.feature.home.Home

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home,
        modifier = modifier
    ) {
        composable<Routes.Home> {
            Home(
                onNavigate = { navController.navigate(it) }
            )
        }

        composable<Routes.Favorites> {
            Favorites(
                onNavigate = { navController.navigate(it) }
            )
        }

        composable<Routes.Detail> {
            Detail(
                onNavigate = { navController.navigate(it) }
            )
        }
    }
}