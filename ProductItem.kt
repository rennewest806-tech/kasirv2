package com.droidgen.kasirku.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Long,
    val stock: Int,
    val category: String,
    val barcode: String? = null,
    val imageUri: String? = null
)
