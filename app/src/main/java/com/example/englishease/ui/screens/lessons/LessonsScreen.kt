package com.example.englishease.ui.screens.lessons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.englishease.R

@Composable
fun LessonsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Lessons Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}


@Composable
fun ShowCard(
    lessonName: String,
    lessonDescription: String,
    modifier: Modifier = Modifier
) {

    ElevatedCard(
        modifier = modifier
            .size(width = 280.dp, height = 100.dp)
    ) {
        Row {
            Column(
                modifier = modifier
                    .weight(0.8f)
                    .padding(
                        start = 5.dp,
                        top = 5.dp,
                        bottom = 5.dp,
                        end = 10.dp
                    )
            ) {
                Text(
                    text = lessonName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = lessonDescription,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Justify,
                    modifier = modifier
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowCard() {
    ElevatedCard(
        modifier = Modifier
            .size(width = 280.dp, height = 100.dp)
    ) {
        Row {
            Column(
                modifier = Modifier
                    .weight(0.8f)
                    .padding(
                        start = 5.dp,
                        top = 5.dp,
                        bottom = 5.dp,
                        end = 10.dp
                    )
            ) {
                Text(
                    text = "Present tense",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "some text description " +
                            "some text description " +
                            "some text description " +
                            "some text description ",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                )
            }
        }
    }
}