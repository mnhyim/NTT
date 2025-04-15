package com.mnhyim.nexmediatechtest.domain.model

import android.net.Uri

data class Product(
    val id: Long,
    val name: String,
    val price: Long,
    val stock: Int,
    val imageUri: Uri?,
    val isFavorite: Boolean
)