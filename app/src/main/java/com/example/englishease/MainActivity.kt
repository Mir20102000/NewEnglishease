package com.example.englishease

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.englishease.ui.lessons.InnerContent

data class BottomNavigationItem(
    val title: String, val selectedIcon: Painter, val unselectedIcon: Painter
)

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
        }
    )
}

@Composable
fun MyBottomAppBar() {

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