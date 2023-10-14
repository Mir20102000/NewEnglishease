package com.example.englishease

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.example.englishease.ui.Navigation
import com.example.englishease.ui.Screen
import com.example.englishease.ui.lessons.InnerContent

data class BottomNavigationItem(
    val title: String, val selectedIcon: Painter, val unselectedIcon: Painter
) {

}

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            MyTopAppBar()
                        }, bottomBar = {
                            MyBottomAppBar()
                        }) {
                        InnerContent(Modifier.padding(it))
                    }
                }
            }
        }
    }
}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ChooseCourseScreen(modifier: Modifier = Modifier) {
//    Scaffold(
//        topBar = {
//            MyTopAppBar()
//        },
//        bottomBar = {
//            MyBottomAppBar()
//        }
//    ) {
//        InnerContent(modifier.padding(it))
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Text(
                text = stringResource(R.string.app_name), fontWeight = FontWeight.Bold
            )
        },
//        actions = {
//            Icon(
//                imageVector = Icons.Default.Search,
//                contentDescription = null,
//                modifier = Modifier.clickable { /*TODO*/ }
//            )
//            Icon(
//                painter = painterResource(R.drawable.ic_profile),
//                contentDescription = null,
//                modifier = Modifier.clickable { /*TODO*/ }
//            )
//        }
    )
}

@Composable
fun MyBottomAppBar() {

    var selectedIcon by remember { mutableIntStateOf(0) }
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    val items = listOf(
        BottomNavigationItem(
            title = "Lessons",
            selectedIcon = painterResource(R.drawable.book),
            unselectedIcon = painterResource(R.drawable.book)
        ), BottomNavigationItem(
            title = "Practise",
            selectedIcon = painterResource(R.drawable.practise),
            unselectedIcon = painterResource(R.drawable.practise)
        ), BottomNavigationItem(
            title = "Profile",
            selectedIcon = painterResource(R.drawable.user),
            unselectedIcon = painterResource(R.drawable.user)
        )
    )

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
//                navController.navigate(Screen.Lessons.route)
//                navController.navigate(item.title)
                },
                label = { Text(item.title) },
                icon = {
                    Icon(
                        painter = if (index == selectedItemIndex) item.selectedIcon
                        else item.unselectedIcon,
                        contentDescription = item.title,
                        modifier = Modifier.size(25.dp)
                    )
                })
        }
//        NavigationBarItem(selected = selectedIcon == 0, onClick = {
//            selectedIcon = 0
////                navController.navigate(Screen.Lessons.route)
//        }, label = { Text("Lessons") }, icon = {
//            Icon(
//                painter = painterResource(R.drawable.book),
//                contentDescription = null,
//                modifier = Modifier.size(25.dp)
//            )
//        })
//
//        NavigationBarItem(selected = selectedIcon == 1, onClick = {
//            selectedIcon = 1
////                navController.navigate(Screen.Practise.route)
//        }, label = { Text("Practise") }, icon = {
//            Icon(
//                painter = painterResource(R.drawable.practise),
//                contentDescription = null,
//                modifier = Modifier.size(25.dp)
//            )
//        })
//
//        NavigationBarItem(selected = selectedIcon == 2, onClick = {
//            selectedIcon = 2
////                navController.navigate(Screen.Profile.route)
//        }, label = { Text("Profile") }, icon = {
//            Icon(
//                painter = painterResource(R.drawable.user),
//                contentDescription = null,
//                modifier = Modifier.size(25.dp)
//            )
//        })

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