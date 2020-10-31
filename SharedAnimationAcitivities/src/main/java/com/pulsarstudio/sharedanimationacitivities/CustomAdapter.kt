package com.pulsarstudio.sharedanimationacitivities

import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val imageList: List<Int>, private val sourceActivity: SourceActivity) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val vh = LayoutInflater.from(sourceActivity).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(vh, sourceActivity)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    class MyViewHolder(itemView: View, private val activity: SourceActivity) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var resId: Int? = null
        val image = itemView.findViewById<ImageView>(R.id.rv_image_view)
        fun onBind(resId: Int) {
            this.resId = resId
            image.setImageResource(resId)
            image.transitionName = resId.toString()
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Intent(activity, DestinationActivity::class.java).apply {
                putExtra("shared_image", resId)
                val options = ActivityOptions.makeSceneTransitionAnimation(activity, image, image.transitionName)
                activity.startActivity(this, options.toBundle())
            }
        }
    }
}
