package es.animaldevs.app.injection.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import es.animaldevs.app.App
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class
])
interface AppComponent : AndroidInjector<App> {
    override fun inject(application: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}