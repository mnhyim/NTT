package com.mnhyim.nexmediatechtest.ui.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.nexmediatechtest.domain.model.Product
import com.mnhyim.nexmediatechtest.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
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
    val products = combine(_products, _searchQuery) { productList, query ->
        if (query.isBlank()) productList
        else productList.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
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