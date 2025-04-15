package com.mnhyim.nexmediatechtest.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.mnhyim.nexmediatechtest.ui.navigation.NavigationItems
import com.mnhyim.nexmediatechtest.ui.navigation.Routes

@Composable
fun BottomNavigation(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    val destinations = listOf(
        NavigationItems.Home,
        NavigationItems.Favorites,
        NavigationItems.Settings
    )

    var selectedItem: NavigationItems by remember { mutableStateOf(NavigationItems.Home) }

    NavigationBar {
        destinations.forEach { dest ->
            NavigationBarItem(
                selected = dest == selectedItem,
                onClick = {
                    onNavigate(dest.route)
                    selectedItem = dest
                },
                icon = { Icon(imageVector = dest.icon, contentDescription = "") },
                label = { Text(text = dest.title) }
            )
        }
    }
}