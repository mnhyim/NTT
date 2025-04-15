package com.mnhyim.nexmediatechtest.ui.feature.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.nexmediatechtest.domain.model.Product
import com.mnhyim.nexmediatechtest.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private var _products = MutableStateFlow(emptyList<Product>())
    val products = _products.asStateFlow()

    init {
        viewModelScope.launch {
            productRepository.getAllFavoriteProducts().collect {
                _products.value = it
            }
        }
    }

    fun favoriteItem(product: Product) {
        viewModelScope.launch {
            productRepository.updateProduct(product.copy(isFavorite = !product.isFavorite))
        }
    }
}