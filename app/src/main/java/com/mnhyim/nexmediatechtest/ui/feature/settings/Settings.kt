package com.mnhyim.nexmediatechtest.ui.feature.settings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mnhyim.nexmediatechtest.ui.navigation.Routes

@Composable
fun Settings(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    SettingsScreen(modifier)
}

@Composable
private fun SettingsScreen(
    modifier: Modifier = Modifier
) {
    Text("SettingsScreen", modifier)
}