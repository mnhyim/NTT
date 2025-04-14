package com.mnhyim.nexmediatechtest.ui.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.provider.FontsContractCompat.Columns

@Composable
fun Home(
    modifier: Modifier = Modifier
) {
    HomeScreen(modifier = modifier)
}

@Composable
private fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text("Home Screen")
    }
}