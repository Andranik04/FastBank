package com.fastcredit.fcbank.common.binding

import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.fastcredit.fcbank.common.BindableAdapter
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

@BindingAdapter("data")
fun <T> RecyclerView.bindRecyclerViewData(@Nullable items: T?) {
    @Suppress("UNCHECKED_CAST")
    (adapter as? BindableAdapter<T>)?.setItems(items)
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

@BindingAdapter("src")
fun ImageView.bindImageViewResource(publicImageUrl: String?) {
    publicImageUrl?.let {
        Glide.with(this.context)
            .load(publicImageUrl)
            .transition(withCrossFade())
            .into(this)
    }
}