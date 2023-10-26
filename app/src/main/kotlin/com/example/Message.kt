import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val senderUserId: Long,  // Foreign key
    val receiverUserId: Long,  // Foreign key
    val content: String,
    val timestamp: Long,
)