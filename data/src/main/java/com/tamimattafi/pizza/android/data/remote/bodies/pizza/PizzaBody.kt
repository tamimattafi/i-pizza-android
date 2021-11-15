package com.tamimattafi.pizza.android.data.remote.bodies.pizza

import com.fasterxml.jackson.annotation.JsonProperty
import com.tamimattafi.pizza.domain.model.Pizza

data class PizzaBody(
    @JsonProperty(value = "id", required = true)
    val id: Int,
    @JsonProperty(value = "name", required = true)
    val name: String,
    @JsonProperty(value = "description", required = true)
    val description: String,
    @JsonProperty(value = "imageUrls", required = true)
    val imageUrls: List<String>,
    @JsonProperty(value = "price", required = true)
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
        fun Pizza.toEntity() = PizzaBody(
            id,
            name,
            description,
            imageUrls,
            price
        )
    }
}