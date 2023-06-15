package mx.com.cfe.cfecontig.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import mx.com.cfe.cfecontig.CandyConstants
import mx.com.cfe.cfecontig.R

@Composable
fun GameSurface(navController: NavHostController){

    val screenHeight = LocalConfiguration.current.screenHeightDp

    var isTapTwice = remember {
        mutableStateOf(false)
    }

    var scoreCounter = remember {
        mutableStateOf(0)
    }

    var speed = remember {
        mutableStateOf(3500)
    }

    val animation1 = remember {
        Animatable(initialValue = 0f)
    }

    val animation2 = remember {
        Animatable(initialValue = 0f)
    }

    val animation3 = remember {
        Animatable(initialValue = 0f)
    }

    val animation4 = remember {
        Animatable(initialValue = 0f)
    }

    val animation5 = remember {
        Animatable(initialValue = 0f)
    }



    var isVisibleElement1 = remember {
        mutableStateOf(true)
    }

    var isVisibleElement2 = remember {
        mutableStateOf(true)
    }

    var isVisibleElement3 = remember {
        mutableStateOf(true)
    }

    var isVisibleElement4 = remember {
        mutableStateOf(true)
    }

    var isVisibleElement5 = remember {
        mutableStateOf(true)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.candyback),
            contentScale = ContentScale.FillBounds,
            contentDescription = "background",
            modifier = Modifier.fillMaxSize()
        )


        Image(
            painter = painterResource(id = R.drawable.game_light),
            contentDescription = "game light",
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.TopCenter)
        )

        Box(modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
        ) {
            //Place where objects are falling

            if (isVisibleElement1.value){
                Image(
                    painter = painterResource(id = R.drawable.candycandy),
                    contentDescription = "falling element candy",
                    modifier = Modifier
                        .offset(y = animation1.value.dp)
                        .align(Alignment.TopCenter)
                        .clickable {
                            scoreCounter.value += 1
                            isVisibleElement1.value = false
                        }
                )
            }

            if (isVisibleElement2.value){
                Image(
                    painter = painterResource(id = R.drawable.candybanan),
                    contentDescription = "falling element banan",
                    modifier = Modifier
                        .offset(y = animation2.value.dp, x = 32.dp)
                        .align(Alignment.TopCenter)
                        .clickable {
                            scoreCounter.value += 1
                            isVisibleElement2.value = false
                        }
                )
            }

            if (isVisibleElement3.value){
                Image(
                    painter = painterResource(id = R.drawable.candyapple),
                    contentDescription = "falling element apple",
                    modifier = Modifier
                        .offset(y = animation3.value.dp, x = (-32).dp)
                        .align(Alignment.TopCenter)
                        .clickable {
                            scoreCounter.value += 1
                            isVisibleElement3.value = false
                        }
                )
            }

            if (isVisibleElement4.value){
                Image(
                    painter = painterResource(id = R.drawable.candymentol),
                    contentDescription = "falling element mentol",
                    modifier = Modifier
                        .offset(y = animation4.value.dp, x = (-12).dp)
                        .align(Alignment.TopCenter)
                        .clickable {
                            scoreCounter.value += 1
                            isVisibleElement4.value = false
                        }
                )
            }

            if (isVisibleElement5.value){
                Image(
                    painter = painterResource(id = R.drawable.candymint),
                    contentDescription = "falling element candymint",
                    modifier = Modifier
                        .offset(y = animation5.value.dp, x = (-48).dp)
                        .align(Alignment.TopCenter)
                        .clickable {
                            scoreCounter.value += 1
                            isVisibleElement5.value = false
                        }
                )
            }
        }

        LaunchedEffect(key1 = "anim1"){
            isTapTwice.value = true
            delay(2500)
            isTapTwice.value = false

            animation1.animateTo(
                targetValue = screenHeight.toFloat(),
                animationSpec = infiniteRepeatable(
                    tween(speed.value, delayMillis = 50, easing = FastOutLinearInEasing),
                    repeatMode = RepeatMode.Restart
                ))
        }

        LaunchedEffect(key1 = "anim2"){

            delay(2500)

            animation2.animateTo(
                targetValue = screenHeight.toFloat(),
                animationSpec = infiniteRepeatable(
                    tween(speed.value, delayMillis = 300, easing = FastOutLinearInEasing),
                    repeatMode = RepeatMode.Restart
                ))
        }

        LaunchedEffect(key1 = "anim3"){

            delay(2500)


            animation3.animateTo(
                targetValue = screenHeight.toFloat(),
                animationSpec = infiniteRepeatable(
                    tween(speed.value, delayMillis = 700, easing = FastOutLinearInEasing),
                    repeatMode = RepeatMode.Restart
                ))
        }

        LaunchedEffect(key1 = "anim4"){

            delay(2500)


            animation4.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(speed.value, delayMillis = 1500, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Restart
            ))
        }

        LaunchedEffect(key1 = "anim5"){

            delay(2500)

            animation5.animateTo(
                targetValue = screenHeight.toFloat(),
                animationSpec = infiniteRepeatable(
                    tween(speed.value, delayMillis = 0, easing = FastOutLinearInEasing),
                    repeatMode = RepeatMode.Restart
                ))
        }


        LaunchedEffect(key1 = "show elements"){
            delay(2500)

            repeat(10){
                delay(5000)
                isVisibleElement1.value = true
                isVisibleElement2.value = true
                isVisibleElement3.value = true
                isVisibleElement4.value = true
                isVisibleElement5.value = true
                speed.value = speed.value-700
            }
        }


        Image(
            painter = painterResource(id = R.drawable.game_base),
            contentDescription = "game base",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .padding(8.dp)
                .height(50.dp)
        ) {

        Image(
            painter = painterResource(id = R.drawable.table),
            contentDescription = "score table",
        )

        Text(
            text = "Scores is: ${scoreCounter.value}",
            fontFamily = CandyConstants.MAIN_FONT,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Center)
        )

        Image(
            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
            contentDescription = "button back",
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.TopStart)
                .clickable {
                    navController.navigate(Screens.StartCandyScreen.route)
                }
        )
        }

        AnimatedVisibility(
            visible = isTapTwice.value,
            enter = fadeIn() + slideInHorizontally(),
            exit = fadeOut() + slideOutHorizontally()
        ){
            Text(
                text = "Tap twice !!",
                fontFamily = CandyConstants.MAIN_FONT,
                fontSize = 72.sp,
                color = Color.Yellow
            )
        }
    }

    BackHandler(enabled = true) {
        //Nothing to do
    }
}
