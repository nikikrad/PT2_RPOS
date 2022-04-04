package com.example.pt2_rpos.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPerson(personEntity: PersonEntity)

    @Query("SELECT * FROM person_table")
    fun readAllData(): List<PersonEntity>

}