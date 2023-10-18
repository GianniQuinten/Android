import androidx.room.Entity
import androidx.room.PrimaryKey

// test to see if i can follow the slides
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val userType: String,
    val name: String,
    val lastName: String,
    val email: String,
    val password: String,

)
