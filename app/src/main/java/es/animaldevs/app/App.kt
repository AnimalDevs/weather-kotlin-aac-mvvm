package es.animaldevs.app

import dagger.android.DaggerApplication
import es.animaldevs.app.injection.component.DaggerAppComponent
import timber.log.Timber
import timber.log.Timber.DebugTree


class App : DaggerApplication() {
    private val applicationInjector = DaggerAppComponent.builder()
            .application(this)
            .build()

    override fun applicationInjector() = applicationInjector

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}