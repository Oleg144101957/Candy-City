package mx.com.cfe.cfecontig.ui.screens

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import mx.com.cfe.cfecontig.CandyConstants
import mx.com.cfe.cfecontig.CandyService
import mx.com.cfe.cfecontig.CandyService2
import mx.com.cfe.cfecontig.domaincandy.CandyHelper
import mx.com.cfe.cfecontig.domaincandy.CreationProcess
import mx.com.cfe.cfecontig.models.User
import mx.com.cfe.cfecontig.ui.theme.CandyCityTheme
import mx.com.cfe.cfecontig.ui.vm.UserViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var broadcast_zucker: BroadcastReceiver
    private lateinit var broadcast_brin: BroadcastReceiver
    private val vm: UserViewModel by viewModels()
    private lateinit var candyHelper: CandyHelper
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        candyHelper = CandyHelper(this)
        sharedPreferences = getSharedPreferences(CandyConstants.SHARED_PREF, Context.MODE_PRIVATE)
        val person = sharedPreferences.getString(
            CandyConstants.SHARED_PERSON_KEY,
            CandyConstants.SHARED_PERSON_DEFAULT_VALUE
        )

        setContent {
            CandyCityTheme {
                if(person == CandyConstants.SHARED_PERSON_DEFAULT_VALUE){
                    setObservers()
                    startCandyServices()
                }

                Navigation(viewModel = vm){
                    setBack(it)
                }
            }
        }
    }

    private fun setObservers() {
        vm.mapOfResponses.observe(this){
            if (it?.size == 2){
                val destination = CreationProcess(g = it[CandyConstants.BR]!!, it[CandyConstants.ZU]!!)
                //Put it into the Room
                val user = User(
                    id = 0,
                    movement = destination.create(),
                    dba = candyHelper.isCandy(),
                    name = candyHelper.name(),
                    model = candyHelper.model(),
                    boot = candyHelper.boot(),
                    fingerprint = candyHelper.fingerprint()
                )
                vm.addUser(user)
            }
            Log.d("123123", "size of live map is ${it?.size}")
        }
    }

    private fun startCandyServices(){

        startService(Intent(this, CandyService::class.java))
        broadcast_zucker = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                val zucker_res = intent?.getStringExtra(CandyConstants.SERVICE_RESPONSE_Z)
                vm.addZucker(zucker_res!!)
            }
        }

        val intentFilterZu = IntentFilter(CandyConstants.BROADCAST_ACTION_Z)
        registerReceiver(broadcast_zucker, intentFilterZu)

        startService(Intent(this, CandyService2::class.java))
        broadcast_brin = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                val brin_res = intent?.getStringExtra(CandyConstants.SERVICE_RESPONSE_B)
                vm.addBrin(brin_res!!)
            }
        }

        val intentFilterBri = IntentFilter(CandyConstants.BROADCAST_ACTION_B)
        registerReceiver(broadcast_brin, intentFilterBri)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcast_zucker)
        unregisterReceiver(broadcast_brin)
    }

    private fun setBack(candyView : WebView){
        onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (candyView.canGoBack()) {
                        candyView.goBack()
                    } else{
                        //To do nothing
                    }
                }
            }
        )
    }
}