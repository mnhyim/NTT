package com.mnhyim.nexmediatechtest.ui.feature.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mnhyim.nexmediatechtest.domain.model.Product
import com.mnhyim.nexmediatechtest.ui.components.EmptyState
import com.mnhyim.nexmediatechtest.ui.components.ProductItem
import com.mnhyim.nexmediatechtest.ui.navigation.Routes

@Composable
fun Favorites(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: FavoritesViewModel = hiltViewModel(),
) {
    val products by viewModel.products.collectAsStateWithLifecycle()

    FavoritesScreen(
        products = products,
        onNavigate = onNavigate,
        onFavorite = { viewModel.favoriteItem(it) },
        modifier = modifier
    )
}

@Composable
private fun FavoritesScreen(
    products: List<Product>,
    onNavigate: (Routes) -> Unit,
    onFavorite: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "Favorites Products",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )

        if (products.isEmpty()) {
            Spacer(Modifier.weight(1f))
            EmptyState(
                icon = Icons.Outlined.Favorite,
                title = "No Favorites.",
                subtitle = "Your favorite products will appear here, Mark items as favorites to quickly find them again."
            )
            Spacer(Modifier.weight(1f))
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp)
        ) {
            items(items = products, key = { it.id }) { product ->
                ProductItem(
                    product = product,
                    onClick = { onNavigate(Routes.Detail(product.id)) },
                    onFavorite = { onFavorite(product) }
                )
            }
        }

    }
}