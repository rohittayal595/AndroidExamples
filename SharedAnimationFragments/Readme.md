#SharedAnimationFragments

```
fragment
   .fragmentManager
   ?.beginTransaction()
   ?.setReorderingAllowed(true)
   ?.addSharedElement(imageView, imageView.transitionName)
   ?.replace(R.id.fragment_container, imageFragment)?.addToBackStack(null)?.commit()
```

```
val transition = TransitionInflater.from(context).inflateTransition(R.transition.shared_image)
sharedElementEnterTransition = transition
```

```
# R.transition.shared_image.xml
<?xml version="1.0" encoding="utf-8"?>
<transitionSet>
    <changeClipBounds />
    <changeTransform />
    <changeBounds />
</transitionSet>
```
