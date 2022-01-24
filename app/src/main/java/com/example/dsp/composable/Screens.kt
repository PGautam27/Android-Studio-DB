package com.example.dsp.composable

sealed class Screens(val route: String) {
    object CallDatabase : Screens(route = "call_database")
    object InfoPage : Screens(route = "info_page")
}