package com.example.dsp.composable

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.InfoPage.route){
        composable(route = Screens.InfoPage.route){
            InfoPage(navController = navController)
        }
        composable(route = Screens.CallDatabase.route){
            entry->
            CallDatabase()
        }
    }
}