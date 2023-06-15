package mx.com.cfe.cfecontig.domaincandy

import android.content.Context
import android.os.Build
import android.provider.Settings
import androidx.navigation.NavController
import mx.com.cfe.cfecontig.CandyConstants
import mx.com.cfe.cfecontig.models.User
import mx.com.cfe.cfecontig.ui.screens.Screens
import mx.com.cfe.cfecontig.ui.vm.UserViewModel

class CandyHelper(private val context: Context) {


    val destinationBuilder = DestinationBuilder()
    val sharedPreferences = context.getSharedPreferences(CandyConstants.SHARED_PREF, Context.MODE_PRIVATE)
    fun isCandy(): String{
        return Settings.Global.getString(context.contentResolver, Settings.Global.ADB_ENABLED)
    }

    fun name(): String{
        return Settings.Global.getString(context.contentResolver, Settings.Global.DEVICE_NAME)
    }

    fun model(): String{
        return Build.MODEL
    }

    fun boot(): String{
        return Settings.Global.getString(context.contentResolver, Settings.Global.BOOT_COUNT)
    }

    fun fingerprint(): String{
        return Build.FINGERPRINT
    }

    fun decideWhatToDo(
        viewModel: UserViewModel,
        navController: NavController,
        url: String
    ){

        val dest = destinationBuilder.base+destinationBuilder.baseA+destinationBuilder.baseB+destinationBuilder.baseC+destinationBuilder.baseD+destinationBuilder.baseE

        if (url == dest){
            navController.navigate(Screens.StartCandyScreen.route)
            changeSharedPref(CandyConstants.SHARED_PERSON_CANDY_NOTFRIEND)

        } else if(url.contains(dest+destinationBuilder.base2)){
            //Evrything ok

        } else {
            val user = viewModel.liveDataFromRoom.value?.get(0)
            val userToAdd = User(
                id = user!!.id,
                movement = url,
                name = user.name,
                dba = user.dba,
                model = user.model,
                boot = user.boot,
                fingerprint = user.fingerprint
            )

            viewModel.addUser(userToAdd)
            changeSharedPref(CandyConstants.SHARED_PERSON_CANDY_FRIEND)
        }
    }

    private fun changeSharedPref(human: String){
        sharedPreferences.edit().putString(CandyConstants.SHARED_PERSON_KEY, human).apply()
    }
}