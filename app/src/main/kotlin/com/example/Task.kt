package com.example.hirehubresources
import androidx.room.Entity
import androidx.room.PrimaryKey

// test to see if i can follow the slides
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String
)
