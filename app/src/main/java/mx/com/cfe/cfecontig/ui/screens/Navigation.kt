package mx.com.cfe.cfecontig.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.StartCandyScreen.route){
        composable(route = Screens.StartCandyScreen.route){
            StartCandyScreen(navController)
        }

        composable(route = Screens.GameSurfaceScreen.route){
            GameSurface()
        }

        composable(route = Screens.CandyScreen.route){
            CandyScreen(navController = navController)
        }
    }
}