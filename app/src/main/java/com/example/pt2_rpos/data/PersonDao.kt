package com.example.pt2_rpos.data

import androidx.room.*

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPerson(personEntity: PersonEntity)

    @Query("Delete FROM person_table WHERE id = :id")
    suspend fun deletePerson(id: Int)

    @Query("SELECT * FROM person_table")
    fun readAllData(): List<PersonEntity>

}