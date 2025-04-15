package com.mnhyim.nexmediatechtest.ui.feature.home

import com.mnhyim.nexmediatechtest.domain.model.Product

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val products: List<Product>) : HomeUiState()
    object Empty : HomeUiState()
}