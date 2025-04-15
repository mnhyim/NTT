package com.mnhyim.nexmediatechtest.domain.repository

import com.mnhyim.nexmediatechtest.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getAllProducts(): Flow<List<Product>>
    fun getAllFavoriteProducts(): Flow<List<Product>>
    suspend fun insertProduct(product: Product)
    suspend fun updateProduct(product: Product)
    suspend fun deleteProduct(product: Product)
}