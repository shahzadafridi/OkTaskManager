package com.brikmas.oktaskmanager.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.brikmas.oktaskmanager.data.categories
import com.brikmas.oktaskmanager.model.Category
import com.brikmas.oktaskmanager.ui.theme.Inter

@OptIn(ExperimentalUnitApi::class)
@Composable
private fun CategoryHeader(category: Category){

    Text(
        text = category.name.split(" ").first(),
        fontFamily = Inter,
        fontWeight = FontWeight(700),
        fontSize = TextUnit(23f, TextUnitType.Sp)
    )
    Text(
        text = category.name.split(" ")[1],
        fontFamily = Inter,
        fontWeight = FontWeight(500),
        fontSize = TextUnit(23f, TextUnitType.Sp)
    )
    Text(
        text = "${category.projects} Projects",
        fontFamily = Inter,
        fontWeight = FontWeight(500),
        fontSize = TextUnit(14f, TextUnitType.Sp),
        modifier = Modifier.padding(top = 8.dp)
    )
}

@OptIn(ExperimentalUnitApi::class)
@Composable
private fun CategoryFooter(category: Category){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "More Info",
            fontFamily = Inter,
            fontWeight = FontWeight(600),
            fontSize = TextUnit(14f, TextUnitType.Sp),
        )
        Box(
            modifier = Modifier
                .background(color = Color.White, RoundedCornerShape(percent = 16))
                .size(width = 32.dp, height = 30.dp)
        ){
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "menuIcon",
                modifier = Modifier
                    .size(width = 18.dp, height = 15.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun CategoryCard(category: Category){
    Box(
        modifier = Modifier
            .size(width = 175.dp, height = 210.dp)
            .padding(8.dp)
            .background(color = category.background, RoundedCornerShape(percent = 16))
    ) {
        Image(
            painter = painterResource(id = com.brikmas.okdownloader.R.drawable.transparent_cut_triangle),
            contentDescription = "background",
            Modifier.align(Alignment.TopEnd)
        )
        Column(modifier = Modifier.padding(top = 18.dp, start = 20.dp, end = 20.dp)) {
            CategoryHeader(category = category)
            CategoryFooter(category = category)
        }
    }
}

@Composable
fun CategorySection(){
    Column {
        CategoryTitle()
        LazyRow(contentPadding = PaddingValues(0.dp)) {
            categories.forEach {
                item { CategoryCard(it) }
            }
        }
    }
}