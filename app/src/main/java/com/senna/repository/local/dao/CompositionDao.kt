package com.senna.repository.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import com.senna.model.databse.Composition

import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface CompositionDao {

    @get:Query("SELECT * FROM composition")
    val compositions: List<Composition>

    @Insert(onConflict = REPLACE)
    fun insertComposition(composition: Composition)

    @Query("DELETE FROM composition WHERE is_public = 1")
    fun removePublicCompositions()

}