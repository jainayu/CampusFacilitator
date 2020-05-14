package com.example.campusfacilitator.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.campusfacilitator.data.db.entities.CURRENT_USER_ID
import com.example.campusfacilitator.data.db.entities.User

//Data Access Object
@Dao
interface UserDao{
    //function to insert or update user
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user: User): Long

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser():LiveData<User>


}