package com.brikmas.oktaskmanager.ui.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("Hello") }
    val interactionSource = remember { MutableInteractionSource() }
    val enabled = true
    val singleLine = true
    val colors = TextFieldDefaults.outlinedTextFieldColors()
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        enabled = enabled,
        singleLine = singleLine,
        shape = RoundedCornerShape(percent = 50),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "searchIcon"
            )
        },
        modifier = Modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.bodyMedium
    )
}