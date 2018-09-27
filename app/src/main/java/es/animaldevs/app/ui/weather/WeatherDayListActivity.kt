package es.animaldevs.app.ui.weather

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import es.animaldevs.app.R
import es.animaldevs.app.base.BaseActivity
import es.animaldevs.app.databinding.ActivityWeatherListBinding
import es.animaldevs.app.injection.ViewModelFactory
import es.animaldevs.app.navigator.Navigator
import timber.log.Timber
import javax.inject.Inject


class WeatherDayListActivity : BaseActivity() {
    private lateinit var binding: ActivityWeatherListBinding
    private lateinit var viewModel: WeatherListViewModel
    private var errorSnackbar: Snackbar? = null

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather_list)

        // Get the support action bar
        val actionBar = supportActionBar

        // Set the action bar title, subtitle and elevation
        actionBar!!.title = "Weather"
        actionBar.elevation = 4.0F

        binding.clueList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(WeatherListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })
        viewModel.itemSelected.observe(this, Observer { item ->
            if (item != null) Timber.d(item.dayAndMonth) else hideError()
        })
        binding.viewModel = viewModel


    }

    private fun showError(@StringRes errorMessage: Int, long: Int = Snackbar.LENGTH_SHORT, withAction: Boolean = false) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, long)
        if (withAction) {
            errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        }
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}