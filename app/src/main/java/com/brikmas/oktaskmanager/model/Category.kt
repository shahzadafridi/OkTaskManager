package com.brikmas.oktaskmanager.model

import androidx.compose.ui.graphics.Color

data class Category(
    val id: Int,
    val name: String,
    val projects: Int,
    val background: Color
)