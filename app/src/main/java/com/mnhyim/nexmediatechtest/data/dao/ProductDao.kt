package com.mnhyim.nexmediatechtest.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mnhyim.nexmediatechtest.data.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAllItems(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM product WHERE product_isFavorite == true")
    fun getAllFavoriteItems(): Flow<List<ProductEntity>>

    @Insert
    suspend fun insertItem(item: ProductEntity)

    @Update
    suspend fun updateItem(item: ProductEntity)

    @Delete
    suspend fun deleteItem(item: ProductEntity)
}