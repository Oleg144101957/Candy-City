package mx.com.cfe.cfecontig.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.com.cfe.cfecontig.ui.vm.UserViewModel


@Composable
fun NavigationFast(viewModel: UserViewModel){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.StartCandyScreen.route){
        composable(route = Screens.StartCandyScreen.route){
            StartCandyScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = Screens.CandyScreen.route){
            CandyScreen(navController = navController, viewModel = viewModel)
        }
    }
}