package com.mnhyim.nexmediatechtest.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    val id: Long = 0,

    @ColumnInfo(name = "item_name")
    val name: String,

    @ColumnInfo(name = "item_price")
    val price: Int,

    @ColumnInfo(name = "item_stock")
    val stock: Int,

    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean
)