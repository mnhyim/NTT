package com.mnhyim.nexmediatechtest.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mnhyim.nexmediatechtest.data.dao.ProductDao
import com.mnhyim.nexmediatechtest.data.entity.ProductEntity

@Database(
    entities = [ProductEntity::class],
    version = 1,
)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}