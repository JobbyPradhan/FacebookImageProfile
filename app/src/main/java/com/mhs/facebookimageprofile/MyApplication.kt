package com.mhs.facebookimageprofile

import android.app.Application
import com.nostra13.universalimageloader.core.ImageLoader

import com.nostra13.universalimageloader.core.ImageLoaderConfiguration



class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Create global configuration and initialize ImageLoader with this configuration
        val config: ImageLoaderConfiguration = ImageLoaderConfiguration.Builder(applicationContext).build()
        ImageLoader.getInstance().init(config)
    }
}