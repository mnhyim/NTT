package com.mnhyim.nexmediatechtest.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CustomBottomNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Surface(
        shadowElevation = 8.dp,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 4.dp)
        ) {
            repeat(4) {
                CustomNavigationBarItem(selected = it == 2)
            }
        }
    }
}

@Composable
fun CustomNavigationBarItem(
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { }
            .padding(16.dp, 8.dp)
    ) {
        Icon(
            imageVector = Icons.Outlined.Home,
            contentDescription = "",
            tint = if (selected) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceTint,
            modifier = Modifier
        )
        Text(
            text = "Home",
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = if (selected) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceTint,
            modifier = Modifier
        )
    }
}