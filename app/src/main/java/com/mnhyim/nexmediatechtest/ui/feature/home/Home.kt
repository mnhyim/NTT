package com.mnhyim.nexmediatechtest.ui.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
fun Home(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val products by viewModel.products.collectAsStateWithLifecycle()

    HomeScreen(
        products = products,
        searchQuery = searchQuery,
        onSearchQueryChanged = viewModel::onSearchQueryChanged,
        onNavigate = onNavigate,
        onFavorite = { viewModel.favoriteItem(it) },
        modifier = modifier
    )
}

@Composable
private fun HomeScreen(
    products: List<Product>,
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    onNavigate: (Routes) -> Unit,
    onFavorite: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChanged,
            placeholder = {
                Text(text = "Search products...")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "",
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 8.dp)
        )

        if (products.isEmpty()) {
            Spacer(Modifier.weight(1f))
            if (searchQuery.isEmpty()) {
                EmptyState(
                    icon = Icons.Outlined.ShoppingCart,
                    title = "Your product list is empty.",
                    subtitle = "Go to Settings to start adding items."
                )
            } else {
                EmptyState(
                    icon = Icons.Outlined.Search,
                    title = "No products found.",
                    subtitle = "Try searching with a different name."
                )
            }
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