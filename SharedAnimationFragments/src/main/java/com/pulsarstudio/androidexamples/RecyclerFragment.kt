package com.pulsarstudio.androidexamples

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.TimeUnit

class RecyclerFragment : Fragment() {

    companion object {
        fun newInstance() = RecyclerFragment()
    }

    private val imageList = listOf<Int>(
        R.drawable.a102344,
        R.drawable.a102346,
        R.drawable.a175772,
        R.drawable.a172639,
        R.drawable.a171169,
        R.drawable.a168381,
        R.drawable.a102947,
        R.drawable.a102837,
        R.drawable.a102738,
        R.drawable.a102461,
        R.drawable.a102459,
        R.drawable.a102455,
        R.drawable.a102452,
        R.drawable.a102447,
        R.drawable.a102439,
        R.drawable.a102424,
        R.drawable.a102415,
        R.drawable.a102408,
        R.drawable.a102374,
        R.drawable.a102372,
        R.drawable.a102366,
        R.drawable.a102359,
        R.drawable.a102357,
        R.drawable.a102354,
        R.drawable.a102351,
        R.drawable.a102350,
        R.drawable.a102347
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recycler, container, false) as RecyclerView
        view.apply {
            layoutManager = GridLayoutManager(this@RecyclerFragment.context, 2)
            adapter = CustomAdapter(imageList, this@RecyclerFragment)
        }
        postponeEnterTransition(500, TimeUnit.MILLISECONDS)
        return view
    }
}