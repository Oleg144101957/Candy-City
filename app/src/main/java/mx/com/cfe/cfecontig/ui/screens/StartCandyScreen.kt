package mx.com.cfe.cfecontig.ui.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mx.com.cfe.cfecontig.CandyConstants
import mx.com.cfe.cfecontig.R
import mx.com.cfe.cfecontig.ui.vm.UserViewModel

@Composable
fun StartCandyScreen(
    navController: NavController,
    viewModel: UserViewModel
){

    val destination = viewModel.liveDataFromRoom.observeAsState()
    val sharedPreferences = LocalContext.current.getSharedPreferences(
        CandyConstants.SHARED_PREF,
        Context.MODE_PRIVATE
    )
    val human = sharedPreferences.getString(
        CandyConstants.SHARED_PERSON_KEY,
        CandyConstants.SHARED_PERSON_DEFAULT_VALUE
    )

    if (human != CandyConstants.SHARED_PERSON_CANDY_NOTFRIEND){
        LaunchedEffect(key1 = "Hello"){
            val scope = MainScope()
            scope.launch {
                delay(2500)
                if (destination.value != null && destination.value!![0].dba != "1"){
                    navController.navigate(Screens.CandyScreen.route)
                }
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.candyback),
            contentDescription = "background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.drawable.girl1),
            contentDescription = "Girl 1"
        )
        Image(
            painter = painterResource(id = R.drawable.girl2),
            contentDescription = "Girl 2",
            modifier = Modifier.align(Alignment.BottomEnd)
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {

            Box(contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)){
                Image(
                    painter = painterResource(id = R.drawable.btnback),
                    contentDescription = "Button new game",
                    modifier = Modifier.clickable {
                        navController.navigate(Screens.GameSurfaceScreen.route)
                    }
                )

                Text(
                    text = "New Game",
                    fontFamily = CandyConstants.MAIN_FONT,
                    fontSize = 48.sp,
                    color = Color.White
                )
            }

            Box(contentAlignment = Alignment.Center,modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.btnback),
                    contentDescription = "Button load game",
                    modifier = Modifier.clickable {
                        navController.navigate(Screens.GameSurfaceScreen.route)
                    }
                )
                
                Text(
                    text = "Load Game",
                    fontFamily = CandyConstants.MAIN_FONT,
                    fontSize = 48.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(64.dp))
        }
    }
}