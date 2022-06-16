package com.rteam.expresscards

import android.app.Application
import android.content.Context

val appContext: Context? by lazy {
    com.rteam.expresscards.Application.appContext
}
class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
    companion object {
        var appContext: Context? = null


    }
}