package com.mnhyim.nexmediatechtest.ui.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.nexmediatechtest.data.dao.ProductDao
import com.mnhyim.nexmediatechtest.data.entity.ProductEntity
import com.mnhyim.nexmediatechtest.domain.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dao: ProductDao
) : ViewModel() {

    private var _products = MutableStateFlow(emptyList<Product>())
    val products = _products.asStateFlow()

    init {
        viewModelScope.launch {
            dao.getAllItems().collect {
                _products.value = it.map { product ->
                    Product(
                        id = product.id,
                        name = product.name,
                        price = product.price,
                        stock = product.stock,
                        isFavorite = product.isFavorite
                    )
                }
            }
        }
    }

    fun favoriteItem(product: Product) {
        viewModelScope.launch {
            dao.updateItem(
                ProductEntity(
                    id = product.id,
                    name = product.name,
                    price = product.price,
                    stock = product.stock,
                    isFavorite = !product.isFavorite
                )
            )
        }
    }
}