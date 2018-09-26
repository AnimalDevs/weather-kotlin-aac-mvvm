package es.animaldevs.app.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.databinding.BindingAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import es.animaldevs.app.utils.extension.getParentActivity

@BindingAdapter("adapter")
fun setAdapter(view: androidx.recyclerview.widget.RecyclerView, adapter: androidx.recyclerview.widget.RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
    }

}@BindingAdapter("mutableInt")
fun setMutableInt(view: TextView, text: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value?.toString() ?: "" })
    }
}

@BindingAdapter("mutableImage")
fun setMutableImg(view: ImageView, src: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && src != null) {
        src.observe(parentActivity, Observer { value ->
            Glide.with(parentActivity)
                    .load(value)
                    .into(view)
        })
    }
}

@BindingAdapter("mutableCirleImage")
fun setMutableCirleImage(view: ImageView, src: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && src != null) {
        src.observe(parentActivity, Observer { value ->
            Glide.with(parentActivity)
                    .load(value)
                    .apply(bitmapTransform(CircleCrop()))
                    .into(view)
        })
    }
}