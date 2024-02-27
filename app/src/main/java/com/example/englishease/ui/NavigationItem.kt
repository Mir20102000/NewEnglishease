package com.example.englishease.ui
import com.example.englishease.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Lessons : NavigationItem(
        route = "lessons",
        icon = R.drawable.book,
        title = "Lessons"
    )

    object Practice : NavigationItem(
        route = "practice",
        icon = R.drawable.practice,
        title = "Practice"
    )

    object Profile : NavigationItem(
        route = "profile",
        icon = R.drawable.user,
        title = "Profile"
    )

    object Login : NavigationItem(
        route = "login",
        icon = R.drawable.book,
        title = "Login"
    )
}
