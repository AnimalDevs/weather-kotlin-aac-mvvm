package es.animaldevs.app.base

import android.arch.lifecycle.ViewModel
import es.animaldevs.app.injection.component.DaggerViewModelInjector
import es.animaldevs.app.injection.component.ViewModelInjector
import es.animaldevs.app.injection.module.DataModule
import es.animaldevs.app.ui.weather.WeatherListViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .dataModule(DataModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is WeatherListViewModel -> injector.inject(this)
        }
    }
}