package m.bonnet.daggerexp.scope.application

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {
    @Provides
    @ApplicationScope
    fun provideApplicationContext(): Context {
        return application.applicationContext
    }
}