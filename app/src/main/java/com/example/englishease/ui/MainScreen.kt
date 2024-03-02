package com.example.englishease.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.englishease.R
import com.example.englishease.ui.lessons.LessonsScreen
import com.example.englishease.ui.login.LoginScreen
import com.example.englishease.ui.practise.PracticeScreen
import com.example.englishease.ui.profile.ProfileScreen
import com.example.englishease.ui.registration.RegistrationScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // State of bottomBar, set state to false, if current page route is "car_details"
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    // State of topBar, set state to false, if current page route is "car_details"
    val topBarState = rememberSaveable { (mutableStateOf(true)) }

    // Subscribe to navBackStackEntry, required to get current route
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // Control TopBar and BottomBar
    when (navBackStackEntry?.destination?.route) {
        "login" -> {
            // Hide BottomBar and TopBar
            bottomBarState.value = false
            topBarState.value = false
        }

        "lessons" -> {
            // Show BottomBar and TopBar
            bottomBarState.value = true
            topBarState.value = true
        }

        "practice" -> {
            // Show BottomBar and TopBar
            bottomBarState.value = true
            topBarState.value = true
        }

        "profile" -> {
            // Show BottomBar and TopBar
            bottomBarState.value = true
            topBarState.value = true
        }
    }

//    var showTopBar by rememberSaveable { mutableStateOf(true) } // to hide top bar in login screen
//    var showBottomBar by rememberSaveable { mutableStateOf(true) } // to hide bottom bar in login screen
//    val navBackStackEntry by navController.currentBackStackEntryAsState()

//    showTopBar = when (navBackStackEntry?.destination?.route) {
//        "login" -> false
//        else -> true
//    }
//
//    showBottomBar = when (navBackStackEntry?.destination?.route) {
//        "login" -> false
//        else -> true
//    }

    Scaffold(
//        topBar = { if (showTopBar) MyTopAppBar() },
//        bottomBar = { if (showBottomBar) BottomNavigationBar(navController) },
        topBar = {
            MyTopAppBar(
                topBarState = topBarState
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                bottomBarState = bottomBarState
            )
        },
        content = {
            Box(modifier = Modifier.padding(it)) {
                Navigation(navController = navController)
            }
        }
    )
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Login.route) {
        composable(NavigationItem.Lessons.route) {
            LessonsScreen()
        }
        composable(NavigationItem.Practice.route) {
            PracticeScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
        composable(NavigationItem.Login.route) {
            LoginScreen(navController)
        }
        composable(NavigationItem.Registration.route) {
            RegistrationScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(topBarState: MutableState<Boolean>) {

    AnimatedVisibility(
        visible = topBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        CenterAlignedTopAppBar(
            colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                scrolledContainerColor = MaterialTheme.colorScheme.applyTonalElevation(
//                    backgroundColor = containerColor,
//                    elevation = TopAppBarSmallTokens.OnScrollContainerElevation
//                ),
//                navigationIconContentColor = TopAppBarSmallTokens.LeadingIconColor.value,
                titleContentColor = MaterialTheme.colorScheme.primary,
//                actionIconContentColor = TopAppBarSmallTokens.TrailingIconColor.value
            ),
            title = {
                Text(
                    text = stringResource(R.string.app_name),
                    fontWeight = FontWeight.Bold
                )
            }
        )
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavController,
    bottomBarState: MutableState<Boolean>
) {

    val items = listOf(
        NavigationItem.Lessons,
        NavigationItem.Practice,
        NavigationItem.Profile
    )

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        NavigationBar {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route



            items.forEach { item ->
                NavigationBarItem(
                    label = { Text(item.title) },
                    icon = {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = item.title,
                            modifier = Modifier.size(25.dp)
                        )
                    },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route)
                        {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                )
            }
        }
    }


}

//@Preview(
//    showBackground = true, showSystemUi = true
//)
//@Composable
//fun GreetingPreview() {
//    AppTheme {
//        ChooseCourseScreen()
//    }
//}