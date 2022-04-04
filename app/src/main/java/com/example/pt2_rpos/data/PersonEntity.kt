package com.example.pt2_rpos.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "person_table", indices = [Index(value = ["name"])])
class PersonEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    @ColumnInfo
    var name: String = ""
    @ColumnInfo
    var result: Int = 0
}