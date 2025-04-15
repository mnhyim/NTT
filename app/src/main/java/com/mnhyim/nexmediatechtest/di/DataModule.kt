package com.mnhyim.nexmediatechtest.di

import android.content.Context
import androidx.room.Room
import com.mnhyim.nexmediatechtest.data.ProductDatabase
import com.mnhyim.nexmediatechtest.data.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext context: Context
    ): ProductDatabase {
        return Room.databaseBuilder(
            context,
            ProductDatabase::class.java,
            "product_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductDao(
        database: ProductDatabase
    ): ProductDao {
        return database.productDao()
    }
}