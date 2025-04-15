package com.mnhyim.nexmediatechtest.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItems(var route: Routes, val icon: ImageVector, var title: String) {
    data object Home : NavigationItems(
        route = Routes.Home,
        icon = Icons.Default.Home,
        title = "Home"
    )

    data object Favorites : NavigationItems(
        route = Routes.Favorites,
        icon = Icons.Default.FavoriteBorder,
        title = "Favorites"
    )

    data object Settings : NavigationItems(
        route = Routes.Settings,
        icon = Icons.Default.Settings,
        title = "Settings"
    )
}