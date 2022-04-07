package com.fastcredit.fcbank.common.binding

import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.fastcredit.fcbank.common.extensions.setVisibleOrGone
import com.fastcredit.fcbank.common.extensions.setVisibleOrInvisible
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by Sargis Khlopuzyan on 4/6/2022.
 *
 * Binding adapters for custom data binding attributes.
 */
@BindingAdapter("visibleOrGone")
fun ProgressBar.bindVisibleOrGone(show: StateFlow<Boolean>) {
    show.value.also {
        this.setVisibleOrGone(it)
    }
}

@BindingAdapter("visibleOrInvisible")
fun ProgressBar.bindVisibleOrInvisible(show: StateFlow<Boolean>) {
    show.value.also {
        this.setVisibleOrInvisible(it)
    }
}

@BindingAdapter("text")
fun TextView.bindText(txt: StateFlow<String>) {
    txt.value.also {
        this.text = it
    }
}

@BindingAdapter("glideSrc")
fun setImageViewResource(imageView: ImageView, publicImageUrl: String?) {
    publicImageUrl?.let {
        Glide.with(imageView.context)
            .load(publicImageUrl)
            .transition(withCrossFade())
            .into(imageView)
    }
}