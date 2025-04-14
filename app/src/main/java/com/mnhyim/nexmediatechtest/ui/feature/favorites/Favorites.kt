package com.mnhyim.nexmediatechtest.ui.feature.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mnhyim.nexmediatechtest.ui.navigation.Routes

@Composable
fun Favorites(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    FavoritesScreen(
        onNavigate = onNavigate,
        modifier = modifier
    )
}

@Composable
private fun FavoritesScreen(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text("Favorites Screen")
    }
}