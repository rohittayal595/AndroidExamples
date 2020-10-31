#SharedAnimationActivities
```
Intent(activity, DestinationActivity::class.java).apply {
    putExtra("shared_image", resId)
    val options = ActivityOptions.makeSceneTransitionAnimation(activity, image, image.transitionName)
    activity.startActivity(this, options.toBundle())
}
```
