package com.mnhyim.nexmediatechtest.ui.feature.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Detail(
    modifier: Modifier = Modifier
) {
    DetailScreen(modifier = modifier)
}

@Composable
private fun DetailScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text("Detail Screen")
    }
}