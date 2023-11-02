package com.example.hirehubresources
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val userType: String,
    val email: String,
    val password: String,

)
