package com.tamimattafi.pizza.android.data.local.entities.order

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tamimattafi.pizza.android.data.local.database.PrimaryDatabase.Tables.ORDERS_TABLE

@Entity(tableName = ORDERS_TABLE)
data class OrderEntity(
    @PrimaryKey val pizzaId: Int,
    val quantity: Int
) {
    object Columns {
        const val PIZZA_ID = "pizzaId"
    }
}