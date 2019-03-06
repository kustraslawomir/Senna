package com.senna.repository.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.senna.repository.local.TableNames.Companion.USER
import com.senna.model.databse.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(users: User)

    @Query("SELECT * FROM $USER")
    fun getUser(): User?

    @Query("SELECT * FROM $USER")
    fun getObservableUser(): LiveData<User>

    @Query("DELETE FROM $USER")
    fun removeUser()

    @Query("SELECT * FROM $USER")
    fun getUserLiveData(): LiveData<User?>
}