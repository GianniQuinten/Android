package com.example.hirehubresources
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "profiles")
data class Profile(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val userId: Long, // Foreign key
    val name: String,
    val lastName: String,
    val userType: String,
    val jobPreference: String,
    val description: String,

// profile_data like contact info visibility
)