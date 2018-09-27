package es.animaldevs.app.ui.weather

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.animaldevs.app.R
import es.animaldevs.app.databinding.ItemWeatherBinding
import es.animaldevs.app.model.local.weatherday.WeatherDay

class WeatherDayListAdapter(private val callbacks: Callbacks? = null)
    : RecyclerView.Adapter<WeatherDayListAdapter.ViewHolder>() {
    private lateinit var items: List<WeatherDay>

    interface Callbacks {
        fun onItemClick(view: View, item: WeatherDay)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemWeatherBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_weather, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return if (::items.isInitialized) items.size else 0
    }

    fun updateWeatherList(items: List<WeatherDay>?) {
        items?.let {
            this.items = it
        } ?: run {
            this.items = arrayListOf()
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener { callbacks?.onItemClick(it, items[adapterPosition]) }
        }

        private val viewModel = WeatherDayItemViewModel()

        fun bind(item: WeatherDay) {
            viewModel.bind(item)
            binding.viewModel = viewModel
        }
    }
}