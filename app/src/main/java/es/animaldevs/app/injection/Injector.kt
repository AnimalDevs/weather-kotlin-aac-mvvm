package es.animaldevs.app.injection

import es.animaldevs.app.App

object Injector {
    private lateinit var appComponent: AppComponent

    @JvmStatic
    @Synchronized
    fun init(application: App) {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(application))
                .build()
    }

    @JvmStatic
    @Synchronized
    fun get(): AppComponent = appComponent
}