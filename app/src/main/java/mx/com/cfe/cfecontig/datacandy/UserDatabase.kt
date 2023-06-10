package mx.com.cfe.cfecontig.datacandy

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mx.com.cfe.cfecontig.CandyConstants
import mx.com.cfe.cfecontig.models.User


@Database(entities = [User::class], exportSchema = true, version = 1)
abstract class UserDatabase : RoomDatabase(){

    abstract fun getUserDao(): UserDao

//    companion object{
//        @Volatile
//        var INSTANCE: UserDatabase? = null
//
//        fun getUserDatabase(context: Context) : UserDatabase {
//            val tmp = INSTANCE
//            if (tmp != null) return tmp
//
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    UserDatabase::class.java,
//                    CandyConstants.USER_DATABASE_NAME
//                ).build()
//
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
}