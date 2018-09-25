package es.animaldevs.app.injection.component

import dagger.Component
import es.animaldevs.app.injection.module.DataModule
import es.animaldevs.app.ui.weather.WeatherListViewModel
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(DataModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified WeatherListViewModel.
     * @param vanadisListViewModel WeatherListViewModel in which to inject the dependencies
     */
    fun inject(vanadisListViewModel: WeatherListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun dataModule(dataModule: DataModule): Builder
    }
}