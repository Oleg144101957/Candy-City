package mx.com.cfe.cfecontig.ui.screens

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.ViewGroup
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import mx.com.cfe.cfecontig.CandyConstants
import mx.com.cfe.cfecontig.R
import mx.com.cfe.cfecontig.domaincandy.CandyHelper
import mx.com.cfe.cfecontig.ui.vm.UserViewModel

@Composable
fun CandyScreen(navController: NavController, viewModel: UserViewModel, onBackPress: (webview: WebView) -> Unit) {

    val candyState = remember {
        mutableStateOf(true)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        CandyPage(
            navController = navController,
            viewModel = viewModel,
            candyState = candyState,
            onBackPress = onBackPress
        )

        if (candyState.value){
            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.candy_bar))
            LottieAnimation(
                composition = composition,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun CandyPage(
    navController: NavController,
    viewModel: UserViewModel,
    candyState: MutableState<Boolean>,
    onBackPress: (webview: WebView) -> Unit
){

    val candyHelper = CandyHelper(LocalContext.current)
    var webView: WebView? = null
    var fileDestinationsCallback: ValueCallback<Array<Uri>>? by remember {
        mutableStateOf(null)
    }
    val launcherForActivityResult = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetMultipleContents()
    ) {
        fileDestinationsCallback!!.onReceiveValue(it.toTypedArray())
    }
    val destination = viewModel.liveDataFromRoom.value?.get(0)?.movement

    AndroidView(factory = { context: Context -> 
    WebView(context).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.loadWithOverviewMode = true
        settings.userAgentString = settings.userAgentString.changeAttr()

        webViewClient = object : WebViewClient(){

            override fun onPageFinished(view: WebView?, url: String) {
                super.onPageFinished(view, url)

                candyHelper.decideWhatToDo(viewModel = viewModel, navController = navController, url = url)

                Log.d("123123", "The url is $url")

                candyState.value = false
            }
        }
        
        webChromeClient = object : WebChromeClient(){
            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {
                fileDestinationsCallback = filePathCallback
                launcherForActivityResult.launch(CandyConstants.LAUNCHER_SETTINGS)
                return true
            }
        }

        loadUrl(destination!!)
    }    
        
    }, update = {
        webView = it
    })

    BackHandler(enabled = true) {
        onBackPress(webView!!)
    }
}

fun String.changeAttr() : String{
    val w = "w"
    val v = "v"
    return this.replace(w+v, "")
}

