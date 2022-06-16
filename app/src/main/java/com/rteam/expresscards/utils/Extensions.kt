package com.rteam.expresscards.utils

import android.graphics.Bitmap
import android.graphics.Color
import android.view.MotionEvent
import com.rteam.expresscards.R
import com.rteam.expresscards.appContext
import com.rteam.expresscards.customview.CustomTry
import java.lang.String

fun checkClickedCategory(event: MotionEvent, wheelSpinCu: CustomTry): kotlin.String {
    val evX = event.x
    val evY = event.y

    val image = wheelSpinCu
    image.isDrawingCacheEnabled = true
    val imgBtmp = Bitmap.createBitmap(image.drawingCache!!)
    image.isDrawingCacheEnabled = false
    val pixel = imgBtmp.getPixel(evX.toInt(), evY.toInt())
    val redComponent = Color.red(pixel)
    val greenComponent = Color.green(pixel)
    val blueComponent = Color.blue(pixel)

    val hex = String.format("#%02x%02x%02x", redComponent, greenComponent, blueComponent)
     when (hex.lowercase()) {
        WheelSectionColors.GREENSECTION.rgbColor.lowercase() -> {
            return WheelSectionColors.GREENSECTION.name
        }
        WheelSectionColors.YELLOWSECTION.rgbColor.lowercase() -> {
            return WheelSectionColors.YELLOWSECTION.name
        }
        WheelSectionColors.BLUESECTION.rgbColor.lowercase() -> {
            return WheelSectionColors.BLUESECTION.name
        }
        WheelSectionColors.LIGHTBLUESECTION.rgbColor.lowercase() -> {
            return WheelSectionColors.LIGHTBLUESECTION.name
        }
        WheelSectionColors.ORANGESECTION.rgbColor.lowercase() -> {
            return WheelSectionColors.ORANGESECTION.name
        }
        WheelSectionColors.PINKSECTION.rgbColor.lowercase() -> {
            return WheelSectionColors.PINKSECTION.name
        }

        else -> { return ""}
    }

}
//            <color name="greensection">#5AC461</color>
//            <color name="bluesection">#3255F4</color>
//            <color name="lightbluesection">#50B5D0</color>
//            <color name="pinksection">#E1325A</color>
//            <color name="yellowsection">#FAA61A</color>
//            <color name="orangesection">#F58220</color>