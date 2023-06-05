package mx.com.cfe.cfecontig.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import mx.com.cfe.cfecontig.CandyConstants
import mx.com.cfe.cfecontig.R
import mx.com.cfe.cfecontig.ui.theme.CandyCityTheme

@Composable
fun StartCandyScreen(){
    val mercadilloBlack = FontFamily(Font(R.font.mercadillo_black))
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
                    contentDescription = "Button new game"
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
                    contentDescription = "Button load game"
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

@Preview(showBackground = true)
@Composable
fun StartCandyScreenPreview() {
    StartCandyScreen()
}