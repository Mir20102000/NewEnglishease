package com.example.englishease.ui.lessons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.englishease.R

@Composable
fun LessonsScreen(modifier: Modifier = Modifier) {

    val travelImg = painterResource(R.drawable.travel)
    val businessImg = painterResource(R.drawable.business)
    val englishImg = painterResource(R.drawable.english)
    val studyImg = painterResource(R.drawable.study)
    val programmerImg = painterResource(R.drawable.programmer)
    val boyImg = painterResource(R.drawable.boy)

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        item() {
            ShowText(
                stringResource(R.string.choose_course_title),
                stringResource(R.string.choose_course_desc)
            )
            Spacer(Modifier.height(20.dp))
        }
        item() {
            ShowCard(
                stringResource(R.string.general_english),
                stringResource(R.string.general_eng_desc),
                englishImg
            )
            Spacer(Modifier.height(10.dp))
        }
        item() {
            ShowCard(
                stringResource(R.string.english_work),
                stringResource(R.string.english_work_desc),
                businessImg
            )
            Spacer(Modifier.height(10.dp))
        }

        item() {
            ShowCard(
                stringResource(R.string.english_study),
                stringResource(R.string.english_study_desc),
                studyImg
            )
            Spacer(Modifier.height(10.dp))
        }

        item() {
            ShowCard(
                stringResource(R.string.english_travel),
                stringResource(R.string.english_travel_desc),
                travelImg
            )
            Spacer(Modifier.height(10.dp))
        }

        item() {
            ShowCard(
                stringResource(R.string.english_it),
                stringResource(R.string.english_it_desc),
                programmerImg
            )
            Spacer(Modifier.height(10.dp))
        }

        item() {
            ShowCard(
                stringResource(R.string.englsih_kids),
                stringResource(R.string.english_kids_desc),
                boyImg
            )
            Spacer(Modifier.height(20.dp))
        }
    }
}

@Composable
fun ShowText(
    mainText: String,
    bottomText: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = mainText,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        modifier = modifier
    )
    Text(
        text = bottomText,
        textAlign = TextAlign.Justify,
        fontSize = 16.sp,
        modifier = modifier
    )

}

@Composable
fun ShowCard(
    text: String,
    courseDescription: String,
    painter: Painter,
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
                    text = text,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = courseDescription,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Justify,
                    modifier = modifier
                )
            }
            Image(
                painter = painter,
                contentDescription = null,
                modifier = modifier
                    .weight(0.2f)
                    .wrapContentHeight(Alignment.CenterVertically)
            )
        }
    }
}