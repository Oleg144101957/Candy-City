package mx.com.cfe.cfecontig.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mx.com.cfe.cfecontig.datacandy.UserRepository
import mx.com.cfe.cfecontig.models.User
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository

    ) : ViewModel() {

    val liveDataFromRoom: LiveData<List<User>> = repository.readAllUserData

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}