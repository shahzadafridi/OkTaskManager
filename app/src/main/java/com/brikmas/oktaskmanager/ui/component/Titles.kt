package com.brikmas.oktaskmanager.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.brikmas.oktaskmanager.ui.theme.Inter

@Composable
fun titleBar(){
    Row(
        modifier =  Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Hello,",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "Shahzad",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "menuIcon",
        )
    }
}

@Composable
fun CategoryTitle(){
    Row(
        modifier =  Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Category",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 2.dp)
        )
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "menuIcon",
        )
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun LatestProjectTitle(){
    Row(
        modifier =  Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Latest Project",
            fontFamily = Inter,
            fontWeight = FontWeight(600),
            fontSize = TextUnit(23f, TextUnitType.Sp)
        )
        Text(
            text = "See More",
            fontFamily = Inter,
            fontWeight = FontWeight(600),
            fontSize = TextUnit(16f, TextUnitType.Sp)
        )
    }
}