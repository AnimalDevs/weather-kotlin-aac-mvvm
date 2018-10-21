package es.animaldevs.app.ui.weather

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.animaldevs.app.R
import es.animaldevs.app.databinding.ItemWeatherBinding
import es.animaldevs.app.model.local.weatherday.WeatherDay
import timber.log.Timber

class WeatherDayListAdapter(private val callbacks: Callbacks? = null)
    : RecyclerView.Adapter<WeatherDayListAdapter.ViewHolder>() {
    private lateinit var items: List<WeatherDay>

    interface Callbacks {
        fun onItemClick(view: View, item: WeatherDay)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Timber.d("onCreateViewHolder")
        val binding: ItemWeatherBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_weather, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Timber.d("onBindViewHolder")
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        if (::items.isInitialized) {
            Timber.d("getItemCount: ${items.size}")

            return items.size
        } else {
            Timber.d("getItemCount: 0")
            return 0
        }
    }

    fun updateWeatherList(items: List<WeatherDay>) {
        Timber.d("updateWeatherList: ${items.size}")

        this.items = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            Timber.d("ViewHolder init")
            itemView.setOnClickListener { callbacks?.onItemClick(it, items[adapterPosition]) }
        }

        private val viewModel = WeatherDayItemViewModel()

        fun bind(item: WeatherDay) {
            Timber.d("ViewHolder bind")

            viewModel.bind(item)
            binding.viewModel = viewModel
        }
    }
}