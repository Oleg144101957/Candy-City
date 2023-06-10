package mx.com.cfe.cfecontig.datacandy

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mx.com.cfe.cfecontig.CandyConstants
import mx.com.cfe.cfecontig.models.User


@Dao
interface UserDao {
    @Query("SELECT * FROM ${CandyConstants.USER_TABLE}")
    fun readAllData(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)
}