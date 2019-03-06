package com.senna.repository.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.senna.model.databse.Composition;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CompositionDao {

   @Insert(onConflict = REPLACE)
   void insertComposition(Composition composition);

   @Query("SELECT * FROM composition")
   List<Composition> getCompositions();
}