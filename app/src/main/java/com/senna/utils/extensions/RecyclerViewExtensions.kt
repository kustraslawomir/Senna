package com.senna.utils.extensions

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.senna.com.R


 fun RecyclerView.startEnterAnimation() {
    val context = this.context
    val controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)
    this.layoutAnimation = controller
    this.adapter?.notifyDataSetChanged()
    this.scheduleLayoutAnimation()
}