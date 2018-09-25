package es.animaldevs.app.injection.module

import dagger.Module
import dagger.Provides
import es.animaldevs.app.navigator.Navigator
import javax.inject.Singleton

@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object NavigatorModule {
    @Provides
    @Singleton
    @JvmStatic
    internal fun provideNavigator(): Navigator {
        //return retrofit.create(CluesApi::class.java)
        return Navigator()
    }


}