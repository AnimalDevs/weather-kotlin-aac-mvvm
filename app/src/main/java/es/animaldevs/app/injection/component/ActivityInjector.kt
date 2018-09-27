package es.animaldevs.app.injection.component

import dagger.Component
import es.animaldevs.app.injection.module.NavigatorModule
import es.animaldevs.app.ui.weather.WeatherDayListActivity
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NavigatorModule::class)])
interface ActivityInjector {

    fun inject(weatherDayListActivity: WeatherDayListActivity)

    @Component.Builder
    interface Builder {
        fun build(): ActivityInjector

        fun navigatorModule(navigatorModule: NavigatorModule): Builder
    }
}