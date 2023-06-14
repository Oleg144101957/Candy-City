package mx.com.cfe.cfecontig.domaincandy

import android.content.Context
import android.os.Build
import android.provider.Settings

class CandyHelper(private val context: Context) {
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


}