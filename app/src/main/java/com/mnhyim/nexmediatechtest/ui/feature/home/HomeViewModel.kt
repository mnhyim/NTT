package com.mnhyim.nexmediatechtest.ui.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.nexmediatechtest.domain.model.Product
import com.mnhyim.nexmediatechtest.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private var _products = MutableStateFlow(emptyList<Product>())
    val uiState: StateFlow<HomeUiState> = combine(_products, _searchQuery) { products, query ->
        val filtered = if (query.isBlank()) products
        else products.filter { it.name.contains(query, ignoreCase = true) }

        when {
            products.isEmpty() -> HomeUiState.Loading
            filtered.isEmpty() -> HomeUiState.Empty
            else -> HomeUiState.Success(filtered)
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        initialValue = HomeUiState.Loading
    )

    init {
        viewModelScope.launch {
            productRepository.getAllProducts().collect {
                _products.value = it
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun favoriteItem(product: Product) {
        viewModelScope.launch {
            productRepository.updateProduct(product.copy(isFavorite = !product.isFavorite))
        }
    }
}