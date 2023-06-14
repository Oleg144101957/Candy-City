package mx.com.cfe.cfecontig

import android.app.Application
import com.onesignal.OneSignal
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class CandyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(CandyConstants.ONE)
    }

}