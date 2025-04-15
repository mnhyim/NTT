package com.mnhyim.nexmediatechtest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
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
    ) {
        Box {
            Image(
                painter = rememberAsyncImagePainter(
                    model = product.imageUri,
                    error = painterResource(R.drawable.placeholder),
                    fallback = painterResource(R.drawable.placeholder) // for null models
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )

            IconButton(
                onClick = onFavorite,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = if (product.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    tint = if (product.isFavorite) Color.Red else Color.Black,
                    contentDescription = "",
                    modifier = Modifier
                        .background(
                            MaterialTheme.colorScheme.surface.copy(alpha = 0.5f),
                            CircleShape
                        )
                        .padding(8.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
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