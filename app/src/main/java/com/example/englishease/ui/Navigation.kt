package com.example.englishease.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.englishease.MyBottomAppBar


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Lessons.route) {
        composable(route = Screen.Lessons.route) {
//            MyBottomAppBar(navController)
        }
        composable(route = Screen.Practise.route) {
//            MyBottomAppBar(navController)
        }
        composable(route = Screen.Profile.route) {
//            MyBottomAppBar(navController)
        }
    }
}