package com.reactivestudio.retrofitcoroutines.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun <T> setImageUrl(imageView: ImageView, data: T) {
    if (data is String) {
        Glide.with(imageView).load(data).into(imageView)
    }
}

@BindingAdapter("setVisible")
fun setVisible(view: View, isLoading: Boolean) {
    view.visibility = if (isLoading) View.VISIBLE else View.GONE
}