package com.mnhyim.nexmediatechtest.ui.feature.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Favorites(
    modifier: Modifier = Modifier
) {
    FavoritesScreen(modifier = modifier)
}

@Composable
private fun FavoritesScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text("Favorites Screen")
    }
}