package mx.com.cfe.cfecontig.ui.screens

sealed class Screens(val route: String) {
    object StartCandyScreen : Screens("start_candy_screen")
    object GameSurfaceScreen : Screens("game_surface_screen")
    object CandyScreen : Screens("candy_screen")

}