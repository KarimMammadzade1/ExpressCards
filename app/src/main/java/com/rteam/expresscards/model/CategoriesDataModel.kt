package com.rteam.expresscards.model

import android.graphics.drawable.Drawable
import com.rteam.expresscards.utils.CategoryTypes

data class CategoriesDataModel(
    val categoryType:CategoryTypes,
    val categoryName:String,
    val percent:String,
    val totalSumm:String,
    val icon: Int,
    val cornerColor:String
)
