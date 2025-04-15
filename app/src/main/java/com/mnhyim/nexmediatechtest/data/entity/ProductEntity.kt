package com.mnhyim.nexmediatechtest.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id")
    val id: Long = 0,

    @ColumnInfo(name = "product_name")
    val name: String,

    @ColumnInfo(name = "product_price")
    val price: Long,

    @ColumnInfo(name = "product_stock")
    val stock: Int,

    @ColumnInfo(name = "product_imageUri")
    val imageUri: String,

    @ColumnInfo(name = "product_isFavorite")
    val isFavorite: Boolean
)