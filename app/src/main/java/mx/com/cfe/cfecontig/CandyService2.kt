package mx.com.cfe.cfecontig

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class CandyService2 : Service() {


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val intent_brin = Intent(CandyConstants.BROADCAST_ACTION_B)
        val scope = MainScope()
        scope.launch(Dispatchers.IO) {
            val brin_response = AdvertisingIdClient.getAdvertisingIdInfo(this@CandyService2).id.toString()
            intent_brin.putExtra(CandyConstants.SERVICE_RESPONSE_B, brin_response)
            sendBroadcast(intent_brin)
        }

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}