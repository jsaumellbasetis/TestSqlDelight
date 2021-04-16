package com.example.kmmbase.androidApp

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigate
import com.example.example.ExampleViewModel
import com.example.kmmbase.androidApp.core.scopednav.navigation.scopedComposable
import com.example.kmmbase.androidApp.example.ExampleScreen

private val startDestinationPath = ExampleScreen.declaredPath

@ExperimentalAnimationApi
@Composable
fun RootNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = startDestinationPath) {
        scopedComposable(ExampleScreen) { _, scope ->
            val vm: ExampleViewModel = scope.get()
            ExampleScreen(vm)
        }
    }
}

private fun navToTopDestination(
    path: String,
    navController: NavController,
) {
    navController.navigate(path) {
        popUpTo(navController.graph.startDestination) {}
    }
}

private fun NavDestination.getRootGraph(): NavGraph? {
    var parentGraph = parent
    while (parentGraph?.parent != null) {
        parentGraph = parentGraph.parent
    }
    return parentGraph
}
