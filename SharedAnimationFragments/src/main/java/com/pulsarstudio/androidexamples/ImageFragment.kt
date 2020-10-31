package com.pulsarstudio.androidexamples

import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import java.util.concurrent.TimeUnit

class ImageFragment : Fragment() {

    companion object {
        private val KEY_IMAGE_RESOURCE: String? = "image_resource"

        fun newInstance(imageRes: Int): ImageFragment {
            return ImageFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_IMAGE_RESOURCE, imageRes)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val imageView = inflater.inflate(R.layout.fragment_image, container, false) as ImageView
        val resId = arguments?.getInt(KEY_IMAGE_RESOURCE) ?: R.drawable.a102344
        imageView.setImageResource(resId)

        imageView.transitionName = resId.toString()
        val transition = TransitionInflater.from(context).inflateTransition(R.transition.shared_image)
        sharedElementEnterTransition = transition

        postponeEnterTransition(500,TimeUnit.MILLISECONDS)
        return imageView
    }
}