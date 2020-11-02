package com.pulsarstudio.sharedtextanimation

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import io.plaidapp.ui.transitions.ReflowText
import kotlinx.android.synthetic.main.activity_source.*

class SourceActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)
        txt_main2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, DestinationActivity::class.java)
        ReflowText.addExtras(intent, ReflowText.ReflowableTextView(txt_main2))
        val options = ActivityOptions.makeSceneTransitionAnimation(this, v, "hello_world")
        startActivity(intent, options.toBundle())
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}