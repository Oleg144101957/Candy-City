package mx.com.cfe.cfecontig.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mx.com.cfe.cfecontig.CandyConstants
import mx.com.cfe.cfecontig.R


@Composable
fun GameSurface(){

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.candyback),
            contentScale = ContentScale.FillBounds,
            contentDescription = "background",
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.drawable.game_base),
            contentDescription = "game base",
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )

        Image(
            painter = painterResource(id = R.drawable.game_light),
            contentDescription = "game light",
            modifier = Modifier
                .align(Alignment.TopCenter)
        )

        Box(modifier = Modifier
            .align(Alignment.TopCenter)
            .fillMaxWidth()
            .padding(8.dp)
            .height(50.dp)) {

            Image(
                painter = painterResource(id = R.drawable.table),
                contentDescription = "score table"

            )

            Text(text = "Scores is: 0", fontFamily = CandyConstants.MAIN_FONT, fontSize = 24.sp)

        }




    }
}

@Preview(showBackground = true)
@Composable
fun GameSurfacePreview() {
    GameSurface()
}