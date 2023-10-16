import androidx.room.Entity
import androidx.room.PrimaryKey

// test to see if i can follow the slides
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val lastname: String,
    val email: String,
    val jobPreference: String,
    val description: String
)
