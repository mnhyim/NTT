package com.mnhyim.nexmediatechtest.ui.feature.detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.mnhyim.nexmediatechtest.domain.model.Product
import com.mnhyim.nexmediatechtest.domain.repository.ProductRepository
import com.mnhyim.nexmediatechtest.ui.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val productRepository: ProductRepository,
) : ViewModel() {

    private val productId = savedStateHandle.toRoute<Routes.Detail>().id

    private var _product = MutableStateFlow<Product?>(null)
    val product = _product.asStateFlow()

    init {
        Log.d("DetailViewModel", "id:$productId")
        viewModelScope.launch {
            _product.value = productRepository.getProductById(productId)
        }
    }


}