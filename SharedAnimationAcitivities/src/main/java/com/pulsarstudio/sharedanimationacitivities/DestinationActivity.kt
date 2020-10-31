package com.pulsarstudio.sharedanimationacitivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class DestinationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val resId = intent.extras?.getInt("shared_image") ?: R.drawable.a102344
        image_view.setImageResource(resId)
        image_view.transitionName = resId.toString()
    }

}