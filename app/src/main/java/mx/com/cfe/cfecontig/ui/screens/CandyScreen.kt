package mx.com.cfe.cfecontig.ui.screens

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay
import mx.com.cfe.cfecontig.R
import mx.com.cfe.cfecontig.ui.vm.UserViewModel

@Composable
fun CandyScreen(navController: NavController, viewModel: UserViewModel) {
    Log.d("123123", "Candy Screen")
    val destination = viewModel.liveDataFromRoom.value?.get(0)?.movement
    //Log.d("123123", "Candy Screen method destination is $destination")

    val candyState = remember {
        mutableStateOf(true)
    }

    LaunchedEffect(key1 = "animation"){
        delay(1900)
        candyState.value = false
    }

    Box(modifier = Modifier.fillMaxSize()) {
        //CandyPage(dest = "https://ru.imgbb.com/")
        CandyPage(dest = destination!!)

        if (candyState.value){
            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.candy_bar))
            val progress by animateLottieCompositionAsState(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                isPlaying = true
            )

            LottieAnimation(
                composition = composition,
                progress = progress,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


@Composable
fun CandyPage(dest: String){
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

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                
                
            }
        }
        
        webChromeClient = object : WebChromeClient(){
            
        }
        
        loadUrl(dest)
        
    }    
        
    })
    
}


fun String.changeAttr() : String{
    val w = "w"
    val v = "v"
    return this.replace(w+v, "")
}

