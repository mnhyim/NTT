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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mnhyim.nexmediatechtest.R
import com.mnhyim.nexmediatechtest.domain.model.Product
import java.text.NumberFormat
import java.util.Locale

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
                    tint = if (product.isFavorite) Color.Red else Color.Gray,
                    contentDescription = ""
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = product.name,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.labelSmall,
            )
            Text(
                text = "Rp${formatWithCommas(product.price.toString())}",
                maxLines = 1,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "${product.stock} item left",
                maxLines = 1,
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
        }
    }
}

fun formatWithCommas(input: String): String {
    return try {
        val number = input.toLong()
        NumberFormat.getNumberInstance(Locale.getDefault()).format(number)
    } catch (e: NumberFormatException) {
        input
    }
}