package com.brikmas.oktaskmanager.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.brikmas.oktaskmanager.R
import com.brikmas.oktaskmanager.ui.theme.*


@OptIn(ExperimentalUnitApi::class)
@Composable
private fun ProjectCardHeader(){
    Text(
        text = "Creating Userflows",
        fontFamily = Inter,
        fontWeight = FontWeight(700),
        fontSize = TextUnit(23f, TextUnitType.Sp),
        color = Primary
    )
    Text(
        text = "UI/UX Design",
        fontFamily = Inter,
        fontWeight = FontWeight(500),
        fontSize = TextUnit(16f, TextUnitType.Sp),
        color = Secondary
    )
}

@OptIn(ExperimentalUnitApi::class)
@Composable
private fun ProjectCardProgress(size: Float, progress: Float){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(17.dp)
        ){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(9.dp))
                    .background(ProgressBgClr)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(size)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(9.dp))
                    .background(ProgressClr)
                    .animateContentSize()
            )
        }
        Text(
            text = "$progress%",
            fontFamily = Inter,
            fontWeight = FontWeight(700),
            fontSize = TextUnit(18f, TextUnitType.Sp),
            color = Primary,
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(0.4f)
        )

    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
private fun ProjectCardButton(){
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = Primary),
        modifier = Modifier.height(55.dp)
    ) {
        Text(
            text = "Open Project",
            fontFamily = Inter,
            fontWeight = FontWeight(500),
            fontSize = TextUnit(14f, TextUnitType.Sp),
            color = Black
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = Icons.Default.ArrowForward,
            modifier = Modifier.size(18.dp),
            contentDescription = "drawable icons",
            tint = Color.Unspecified
        )
    }
}

@Composable
private fun RowScope.ProjectCardLeftPanel(progress: Float){
    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )
    Column(
        modifier = Modifier
            .padding(end = 20.dp)
            .weight(1f)
    ) {
        ProjectCardHeader()
        Spacer(modifier = Modifier.height(16.dp))
        ProjectCardProgress(size,progress)
        Spacer(modifier = Modifier.height(16.dp))
        ProjectCardButton()
    }
}

@Composable
private fun RowScope.ProjectCardRightPanel(){
    Box(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(32.dp))
            .padding(vertical = 8.dp, horizontal = 2.dp)
            .fillMaxHeight()
            .weight(0.2f),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy((-8).dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Black, CircleShape)
                    .size(40.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color.Red, CircleShape)
                    .size(40.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color.Yellow, CircleShape)
                    .size(40.dp)
            )
        }
    }
}

@Composable
fun ProjectCard(){
    var progress by remember { mutableStateOf(0f) }
    Column {
        Box(
            modifier = Modifier
                .size(width = 360.dp, height = 240.dp)
                .padding(8.dp)
                .background(color = Color.Black, RoundedCornerShape(percent = 16))
        ) {
            Image(
                painter = painterResource(id = R.drawable.transparent_cut_triangle),
                contentDescription = "background",
                Modifier.align(Alignment.TopEnd)
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                ProjectCardLeftPanel(progress)
                ProjectCardRightPanel()
            }
        }
    }
    LaunchedEffect(key1 = true){
        progress = 0.7f
    }
}
