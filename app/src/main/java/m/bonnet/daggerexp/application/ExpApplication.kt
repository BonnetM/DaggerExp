package m.bonnet.daggerexp.application

import android.app.Application
import android.content.SharedPreferences
import m.bonnet.daggerexp.scope.application.ApplicationComponent
import m.bonnet.daggerexp.scope.application.ApplicationModule
import m.bonnet.daggerexp.scope.application.DaggerApplicationComponent
import javax.inject.Inject

class ExpApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate() {
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        applicationComponent.inject(this)
        super.onCreate()
    }
}