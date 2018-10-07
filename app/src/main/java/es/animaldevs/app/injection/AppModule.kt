package es.animaldevs.app.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import es.animaldevs.app.App

/**
 * This is where you will inject application-wide dependencies.
 */
@Module(includes = [ViewModelModule::class])
class AppModule(private val application: App) {

    @Provides
    fun provideApplication(): App = application

    @Provides
    fun provideContext(application: App): Context = application.applicationContext
}