package mx.com.cfe.cfecontig

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.facebook.applinks.AppLinkData


class CandyService : Service() {


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val intent_zucker = Intent(CandyConstants.BROADCAST_ACTION_Z)
        AppLinkData.fetchDeferredAppLinkData(this@CandyService){
            intent_zucker.putExtra(CandyConstants.SERVICE_RESPONSE_Z, it?.targetUri.toString())
            sendBroadcast(intent_zucker)
        }

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}