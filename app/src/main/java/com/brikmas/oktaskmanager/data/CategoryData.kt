package com.brikmas.oktaskmanager.data

import com.brikmas.oktaskmanager.model.Category
import com.brikmas.oktaskmanager.ui.theme.categoryCard1
import com.brikmas.oktaskmanager.ui.theme.categoryCard2
import com.brikmas.oktaskmanager.ui.theme.categoryCard3


val categories = arrayListOf<Category>().apply {
    add(
        Category(
            id = 1,
            name = "Product Design",
            projects = 10,
            background = categoryCard1
        )
    )
    add(
        Category(
            id = 1,
            name = "Video Editing",
            projects = 2,
            background = categoryCard2
        )
    )
    add(
        Category(
            id = 1,
            name = "Sound Design",
            projects = 1,
            background = categoryCard3
        )
    )
}