package mx.com.cfe.cfecontig.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import mx.com.cfe.cfecontig.models.User
import mx.com.cfe.cfecontig.ui.theme.CandyCityTheme
import mx.com.cfe.cfecontig.ui.vm.UserViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val user = User(
            id = 0,
            movement = "movement",
            name = "name",
            dba = "dba",
            model = "model",
            boot = "33",
            fingerprint = "fingerprint"
        )
        vm.addUser(user)

        vm.liveDataFromRoom.observe(this){
            if (it.isNotEmpty()){
                Log.d("123123", "The data in room is ${it[0]}")
            }
        }

        setContent {
            CandyCityTheme {
                Navigation()
            }
        }
    }
}