import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MessageDao {
    @Insert
    suspend fun insertMessage(message: Message)

    // this grabs all messages. so you can have a chat conversation
    @Query("SELECT * FROM messages WHERE senderUserId = :senderId AND receiverUserId = :receiverId")
    suspend fun getMessagesBetweenUsers(senderId: Long, receiverId: Long): List<Message>

    // this grabs the message for the user.
    @Query("SELECT * FROM messages WHERE senderUserId = :userId OR receiverUserId = :userId")
    suspend fun getMessagesForUser(userId: Long): List<Message>
}
