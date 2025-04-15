package com.mnhyim.nexmediatechtest.domain.model

data class Product(
    val id: Long,
    val name: String,
    val price: Int,
    val stock: Int,
    val isFavorite: Boolean
)