package es.animaldevs.app.ui.weather

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import es.animaldevs.app.R
import es.animaldevs.app.base.BaseActivity
import es.animaldevs.app.databinding.ActivityWeatherListBinding
import es.animaldevs.app.injection.ViewModelFactory
import es.animaldevs.app.navigator.Navigator
import org.jetbrains.anko.alert
import timber.log.Timber
import javax.inject.Inject


class WeatherListActivity : BaseActivity() {
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

        binding.clueList.layoutManager = androidx.recyclerview.widget
                .LinearLayoutManager(this,
                        RecyclerView.VERTICAL,
                        false)

        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(WeatherListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })
        viewModel.alertMessage.observe(this, Observer { alertMessage ->
            if (alertMessage != null) showAlert(alertMessage)
        })
        viewModel.modelExampleSelected.observe(this, Observer { clue ->
            if (clue != null) Timber.d(clue.title) else hideError()
        })
        binding.viewModel = viewModel


    }

    private fun showAlert(alertMessage: Int) {
        alert(getString(alertMessage)) {
            title = "Alerta"
            positiveButton("Borrar") { viewModel.removeAllClues() }
            negativeButton("Cancelar") { }
        }.show()
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