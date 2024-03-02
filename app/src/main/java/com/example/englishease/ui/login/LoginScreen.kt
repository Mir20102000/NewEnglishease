package com.example.englishease.ui.login

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
//import com.example.englishease.ui.theme.Black
import com.example.englishease.R
import com.example.englishease.ui.NavigationItem
//import com.example.englishease.ui.theme.BlueGray
//import com.example.englishease.ui.theme.Roboto
import com.example.englishease.ui.theme.ScreenOrientation
//import com.example.englishease.ui.theme.dimens

@Composable
fun LoginScreen(navController: NavHostController) {
    Surface() {
        if (ScreenOrientation == Configuration.ORIENTATION_PORTRAIT) {
            PortraitLoginScreen(navController)
        } else {
            LandscapeLoginScreen(navController)
        }

    }
}

@Composable
private fun LandscapeLoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.Center
    ) {
        LoginSection(navController)
        SocialMediaSection()
    }
}

@Composable
private fun PortraitLoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        TopSection()
        Spacer(modifier = Modifier.height(36.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {

            LoginSection(navController)

            Spacer(modifier = Modifier.height(30.dp))

            SocialMediaSection()

        }
        Spacer(modifier = Modifier.weight(0.8f))
        CreateAccountSection(navController)
        Spacer(modifier = Modifier.weight(0.3f))
    }
}

@Composable
private fun ColumnScope.CreateAccountSection(navController: NavHostController) {
//    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    Row(
        modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0XFF64748B),
                        fontSize = MaterialTheme.typography.labelMedium.fontSize,
//                    fontFamily = Roboto,
                        fontWeight = FontWeight.Normal
                    )
                ) {
                    append("Don't have an account? ")
                }
            },
            modifier = Modifier.alignByBaseline()
        )

        ClickableText(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0XFF64748B),
                        fontSize = MaterialTheme.typography.labelMedium.fontSize,
//                    fontFamily = Roboto,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Create now")
                }
            },
            onClick = { navController.navigate(NavigationItem.Registration.route) },
            modifier = Modifier.alignByBaseline()
        )
    }


//            withStyle(
//                style = SpanStyle(
//                    color = uiColor,
//                    fontSize = MaterialTheme.typography.labelMedium.fontSize,
////                    fontFamily = Roboto,
//                    fontWeight = FontWeight.Normal
//                )
//            ) {
//                append(" ")
//                append("Create now")
//            }


}

@Composable
private fun SocialMediaSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "Or continue with",
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0XFF64748B))
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialMediaLogIn(
                icon = R.drawable.google,
                text = "Google",
                modifier = Modifier.weight(1f)
            ) {

            }

            Spacer(modifier = Modifier.width(10.dp))

            SocialMediaLogIn(
                icon = R.drawable.facebook,
                text = "Facebook",
                modifier = Modifier.weight(1f)
            ) {

            }
        }
    }
}

@Composable
private fun LoginSection(navController: NavHostController) {
//    val navController = rememberNavController()
    LoginTextField(
        label = "Email",
        trailing = "",
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(15.dp))

    LoginTextField(
        label = "Password",
        trailing = "Forgot?",
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(20.dp))

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        onClick = {
            // problem here
            navController.navigate(NavigationItem.Lessons.route)
        },
//        colors = ButtonDefaults.buttonColors(
//            containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
//            contentColor = Color.White
//        ),
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = "Log in",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}

@Composable
private fun TopSection() {
//    val uiColor = if (isSystemInDarkTheme()) Color.White else Black
    val screenHeight = LocalConfiguration.current.screenHeightDp

    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height((screenHeight / 2.12).dp),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier.padding(top = (screenHeight / 9).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(42.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(R.string.app_logo),
//                tint = uiColor
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = stringResource(id = R.string.the_tolet),
                    style = MaterialTheme.typography.headlineMedium,
//                    color = uiColor
                )
                Text(
                    text = stringResource(id = R.string.find_house),
                    style = MaterialTheme.typography.titleMedium,
//                    color = uiColor
                )
            }
        }
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.BottomCenter),
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.headlineLarge,
//            color = uiColor
        )
    }
}

//@Preview
//@Composable
//fun LoginScreenPreview() {
//    Surface() {
//        if (ScreenOrientation == Configuration.ORIENTATION_PORTRAIT) {
//            PortraitLoginScreen()
//        } else {
//            LandscapeLoginScreen()
//        }
//
//    }
//}