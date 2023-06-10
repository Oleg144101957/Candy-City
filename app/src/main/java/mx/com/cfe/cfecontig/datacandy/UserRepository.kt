package mx.com.cfe.cfecontig.datacandy

import androidx.lifecycle.LiveData
import mx.com.cfe.cfecontig.models.User
import javax.inject.Inject

class UserRepository
@Inject constructor(val userDao: UserDao) {
    val readAllUserData: LiveData<List<User>> = userDao.readAllData()
    fun addUser(user: User){
        userDao.addUser(user)
    }
}