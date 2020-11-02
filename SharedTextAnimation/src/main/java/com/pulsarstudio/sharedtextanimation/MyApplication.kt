package com.pulsarstudio.sharedtextanimation

import android.app.Application
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ViewPump.init(ViewPump.builder()
            .addInterceptor(CalligraphyInterceptor(
                CalligraphyConfig.Builder()
                    .setDefaultFontPath("fonts/roboto-mono-regular.ttf")
                    .setFontAttrId(R.attr.fontPath)
                    .build()
            ))
            .build()
        )
    }
}