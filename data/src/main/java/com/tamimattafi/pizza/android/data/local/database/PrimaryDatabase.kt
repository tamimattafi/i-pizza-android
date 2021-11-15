package com.tamimattafi.pizza.android.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tamimattafi.pizza.android.data.local.database.PrimaryDatabase.Config.EXPORT_SCHEME
import com.tamimattafi.pizza.android.data.local.database.PrimaryDatabase.Config.VERSION
import com.tamimattafi.pizza.android.data.local.database.converters.DatabaseConverters
import com.tamimattafi.pizza.android.data.local.database.dao.PizzaDao
import com.tamimattafi.pizza.android.data.local.entities.PizzaEntity

@Database(
    entities = [PizzaEntity::class],
    version = VERSION,
    exportSchema = EXPORT_SCHEME
)
@TypeConverters(DatabaseConverters::class)
abstract class PrimaryDatabase : RoomDatabase() {

    abstract fun pizzaDao(): PizzaDao

    object Tables {
        const val PIZZA_TABLE = "pizza"
    }

    object Config {
        const val NAME = "primary_database"
        const val VERSION = 1
        const val EXPORT_SCHEME = false
    }
}