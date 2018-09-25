package es.animaldevs.app.ui.weather

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.animaldevs.app.R
import es.animaldevs.app.databinding.ItemWeatherBinding
import es.animaldevs.app.model.ModelExample

class WeatherListAdapter(private val callbacks: Callbacks? = null)
    : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {
    private lateinit var modelExampleList: List<ModelExample>

    interface Callbacks {
        fun onItemClick(view: View, item: ModelExample)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemWeatherBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_weather, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(modelExampleList[position])
    }

    override fun getItemCount(): Int {
        return if (::modelExampleList.isInitialized) modelExampleList.size else 0
    }

    fun updateWeatherList(modelExampleList: List<ModelExample>) {
        this.modelExampleList = modelExampleList
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener { callbacks?.onItemClick(it, modelExampleList[adapterPosition]) }
        }

        private val viewModel = WeatherViewModel()

        fun bind(modelExample: ModelExample) {
            viewModel.bind(modelExample)
            binding.viewModel = viewModel
        }
    }
}