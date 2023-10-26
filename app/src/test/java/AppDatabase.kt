import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class, Task::class, Messages::class Profile::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao
    abstract fun messagesDao(): MessagesDao
    abstract fun profileDao(): ProfileDao
}