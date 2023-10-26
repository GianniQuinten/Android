import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProfileDao {
    @Insert
    suspend fun insert(profile: Profile)

}
