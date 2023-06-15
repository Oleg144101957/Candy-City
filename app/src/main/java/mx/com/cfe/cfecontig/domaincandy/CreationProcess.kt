package mx.com.cfe.cfecontig.domaincandy

import android.util.Log
import com.onesignal.OneSignal

class CreationProcess(private val g: String, private val f: String) {

    fun create(): String{

        var result = ""
        result = if (f != "null"){
            createFStrategy()
        } else {
            createOStrategy()
        }

        OneSignal.setExternalUserId(g)

        return result
    }

    private fun createFStrategy(): String {
        val destination: Destination = DestinationBuilder()
            .gadid_key(g)
            .deeplink_key(f)
            .build()

        Log.d("123123", "The builded link is $destination")
        return destination.toString()
    }

    private fun createOStrategy(): String {
        val destination: Destination = DestinationBuilder()
            .gadid_key(g)
            .build()
        Log.d("123123", "The builded link is $destination")
        return destination.toString()
    }
}