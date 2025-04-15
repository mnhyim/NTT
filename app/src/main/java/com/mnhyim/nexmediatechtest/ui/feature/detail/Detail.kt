package com.mnhyim.nexmediatechtest.ui.feature.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.mnhyim.nexmediatechtest.R
import com.mnhyim.nexmediatechtest.domain.model.Product
import com.mnhyim.nexmediatechtest.ui.components.formatWithCommas
import com.mnhyim.nexmediatechtest.ui.navigation.Routes

@Composable
fun Detail(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val product by viewModel.product.collectAsStateWithLifecycle()

    DetailScreen(
        product = product,
        onNavigate = onNavigate,
        modifier = modifier
    )
}

@Composable
private fun DetailScreen(
    product: Product?,
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        when {
            product == null -> {
                CircularProgressIndicator()
            }

            else -> {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = product.imageUri,
                        error = painterResource(R.drawable.placeholder),
                        fallback = painterResource(R.drawable.placeholder)
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .weight(1f)
                    ) {
                        Text(
                            text = product.name,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                            style = MaterialTheme.typography.labelMedium,
                        )
                        Text(
                            text = "Rp${formatWithCommas(product.price.toString())}",
                            maxLines = 1,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(
                            text = "${product.stock} item left",
                            maxLines = 1,
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.Gray
                        )
                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier.padding(4.dp)
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
            }
        }
    }
}