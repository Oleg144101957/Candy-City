package mx.com.cfe.cfecontig.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mx.com.cfe.cfecontig.CandyConstants
import mx.com.cfe.cfecontig.datacandy.UserDao
import mx.com.cfe.cfecontig.datacandy.UserDatabase
import mx.com.cfe.cfecontig.datacandy.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainCandyModule {

    @Provides
    @Singleton
    fun provideRepository(userDao: UserDao): UserRepository{
        return UserRepository(userDao)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room
        .databaseBuilder(
            context,
            UserDatabase::class.java,
            CandyConstants.USER_DATABASE_NAME
        )
        .allowMainThreadQueries()
        .build()

    @Provides
    @Singleton
    fun provideDao(db: UserDatabase) = db.getUserDao()

}