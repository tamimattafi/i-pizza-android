package com.tamimattafi.pizza.android.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tamimattafi.pizza.android.data.local.database.PrimaryDatabase.Tables.PIZZA_TABLE
import com.tamimattafi.pizza.android.data.local.entities.PizzaEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface PizzaDao {

    @Query("SELECT * FROM $PIZZA_TABLE ORDER BY id ASC")
    fun getAll(): Flowable<List<PizzaEntity>>

    @Query("SELECT * FROM $PIZZA_TABLE WHERE id = :id")
    fun getById(id: Int): Flowable<PizzaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<PizzaEntity>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pizza: PizzaEntity): Completable
}