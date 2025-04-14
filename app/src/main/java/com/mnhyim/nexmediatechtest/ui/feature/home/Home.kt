package com.mnhyim.nexmediatechtest.ui.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mnhyim.nexmediatechtest.ui.navigation.Routes

@Composable
fun Home(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    HomeScreen(
        onNavigate = onNavigate,
        modifier = modifier
    )
}

@Composable
private fun HomeScreen(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
        ) {
            Text("Home Screen")
        }
    }
}