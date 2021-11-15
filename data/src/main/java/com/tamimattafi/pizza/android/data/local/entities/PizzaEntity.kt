package com.tamimattafi.pizza.android.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tamimattafi.pizza.android.data.local.database.PrimaryDatabase.Tables.PIZZA_TABLE
import com.tamimattafi.pizza.domain.model.Pizza

@Entity(tableName = PIZZA_TABLE)
data class PizzaEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val imageUrls: List<String>,
    val price: Double
) {

    fun toPizza() = Pizza(
        id,
        name,
        description,
        imageUrls,
        price
    )

    companion object {
        fun Pizza.toEntity() = PizzaEntity(
            id,
            name,
            description,
            imageUrls,
            price
        )
    }
}