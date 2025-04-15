package com.mnhyim.nexmediatechtest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mnhyim.nexmediatechtest.R
import com.mnhyim.nexmediatechtest.domain.model.Product

@Composable
fun ProductItem(
    product: Product,
    onClick: () -> Unit,
    onFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        onClick = onClick,
        border = CardDefaults.outlinedCardBorder(false),
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.placeholder),
                contentDescription = "",
                modifier = Modifier.clip(RoundedCornerShape(8.dp))
            )
            IconButton(
                onClick = onFavorite,
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = if (product.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = ""
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 8.dp)
        ) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = "${product.price}",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "${product.stock} stock",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
        }
    }
}