package es.animaldevs.app.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import es.animaldevs.app.ui.weather.WeatherListViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(WeatherListViewModel::class)
    internal abstract fun bindWeatherListViewModel(viewModel: WeatherListViewModel): ViewModel
}