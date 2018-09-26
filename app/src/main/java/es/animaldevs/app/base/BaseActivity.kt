package es.animaldevs.app.base

import androidx.appcompat.app.AppCompatActivity
import es.animaldevs.app.injection.component.ActivityInjector
import es.animaldevs.app.injection.component.DaggerActivityInjector
import es.animaldevs.app.injection.module.NavigatorModule
import es.animaldevs.app.ui.weather.WeatherListActivity

abstract class BaseActivity : AppCompatActivity() {
    private val injector: ActivityInjector = DaggerActivityInjector
            .builder()
            .navigatorModule(NavigatorModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is WeatherListActivity -> injector.inject(this)
        }
    }
}