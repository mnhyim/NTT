package com.mnhyim.nexmediatechtest.ui.feature.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.nexmediatechtest.domain.model.Product
import com.mnhyim.nexmediatechtest.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    fun insertProduct(name: String, price: String, stock: String) {
        viewModelScope.launch {
            productRepository.insertProduct(
                Product(
                    id = 0,
                    name = name,
                    price = price.toInt(),
                    stock = stock.toInt(),
                    isFavorite = false
                )
            )
        }
    }
}