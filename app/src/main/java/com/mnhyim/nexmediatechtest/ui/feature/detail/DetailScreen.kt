package com.mnhyim.nexmediatechtest.ui.feature.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mnhyim.nexmediatechtest.ui.navigation.Routes

@Composable
fun Detail(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    DetailScreen(
        onNavigate = onNavigate,
        modifier = modifier
    )
}

@Composable
private fun DetailScreen(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text("Detail Screen")
    }
}