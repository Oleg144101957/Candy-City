package mx.com.cfe.cfecontig.ui.screens

import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.com.cfe.cfecontig.ui.vm.UserViewModel

@Composable
fun Navigation(viewModel: UserViewModel, onBackPress: (web: WebView) -> Unit){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.StartCandyScreen.route){
        composable(route = Screens.StartCandyScreen.route){
            StartCandyScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = Screens.GameSurfaceScreen.route){
            GameSurface(navController = navController)
        }

        composable(route = Screens.CandyScreen.route){
            CandyScreen(navController = navController, viewModel = viewModel, onBackPress = onBackPress)
        }
    }
}