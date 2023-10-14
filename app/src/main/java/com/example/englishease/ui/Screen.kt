package com.example.englishease.ui

sealed class Screen(val route: String) {
    object Lessons : Screen("lessons")
    object Practise : Screen("practise")
    object Profile : Screen("profile")
}
