package es.animaldevs.app.injection

import dagger.Component
import es.animaldevs.app.App
import es.animaldevs.app.ui.weather.WeatherDayListActivity
import es.animaldevs.app.ui.weather.WeatherListViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, NavigatorModule::class, DBModule::class])
interface AppComponent {
    fun inject(application: App)
    fun inject(target: WeatherDayListActivity)
    fun inject(target: WeatherListViewModel)
}