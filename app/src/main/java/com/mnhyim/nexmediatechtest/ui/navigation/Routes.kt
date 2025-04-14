package com.mnhyim.nexmediatechtest.ui.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object Home : Routes()

    @Serializable
    data object Favorites : Routes()

    @Serializable
    data class Detail(val id: Int) : Routes()
}