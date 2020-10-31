package com.pulsarstudio.androidexamples

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.pulsarstudio.androidexamples.CustomAdapter.MyViewHolder

class CustomAdapter(private val imageList: List<Int>, private val fragment: Fragment) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view, fragment)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    class MyViewHolder(itemView: View, private val fragment: Fragment) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val imageView = itemView.findViewById<ImageView>(R.id.rv_image_view)
        private var resId: Int = R.drawable.a102344

        fun onBind(resId: Int) {
            this.resId = resId
            imageView.setImageResource(resId)
            imageView.transitionName = resId.toString()
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val imageFragment = ImageFragment.newInstance(resId)
            fragment
                .fragmentManager
                ?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.addSharedElement(imageView, imageView.transitionName)
                ?.replace(R.id.fragment_container, imageFragment)?.addToBackStack(null)?.commit()
        }
    }
}