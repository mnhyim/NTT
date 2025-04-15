package com.mnhyim.nexmediatechtest.data.repository

import androidx.core.net.toUri
import com.mnhyim.nexmediatechtest.data.dao.ProductDao
import com.mnhyim.nexmediatechtest.data.entity.ProductEntity
import com.mnhyim.nexmediatechtest.domain.model.Product
import com.mnhyim.nexmediatechtest.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val dao: ProductDao
) : ProductRepository {

    override fun getAllProducts(): Flow<List<Product>> {
        return dao.getAllItems().map { products ->
            products.map { product ->
                Product(
                    id = product.id,
                    name = product.name,
                    price = product.price,
                    stock = product.stock,
                    imageUri = product.imageUri.toUri(),
                    isFavorite = product.isFavorite,
                )
            }
        }
    }

    override fun getAllFavoriteProducts(): Flow<List<Product>> {
        return dao.getAllFavoriteItems().map { products ->
            products.map { product ->
                Product(
                    id = product.id,
                    name = product.name,
                    price = product.price,
                    stock = product.stock,
                    imageUri = product.imageUri.toUri(),
                    isFavorite = product.isFavorite
                )
            }
        }
    }

    override suspend fun getProductById(id: Long): Product {
        return dao.getItemById(id).let { product ->
            Product(
                id = product.id,
                name = product.name,
                price = product.price,
                stock = product.stock,
                imageUri = product.imageUri.toUri(),
                isFavorite = product.isFavorite
            )
        }
    }

    override suspend fun insertProduct(product: Product) {
        dao.insertItem(
            ProductEntity(
                name = product.name,
                price = product.price,
                stock = product.stock,
                imageUri = product.imageUri.toString(),
                isFavorite = product.isFavorite
            )
        )
    }

    override suspend fun updateProduct(product: Product) {
        dao.updateItem(
            ProductEntity(
                id = product.id,
                name = product.name,
                price = product.price,
                stock = product.stock,
                imageUri = product.imageUri.toString(),
                isFavorite = product.isFavorite
            )
        )
    }

    override suspend fun deleteProduct(product: Product) {
        dao.deleteItem(
            ProductEntity(
                id = product.id,
                name = product.name,
                price = product.price,
                stock = product.stock,
                imageUri = product.imageUri.toString(),
                isFavorite = product.isFavorite
            )
        )
    }
}