package m.bonnet.daggerexp.scope.application

import android.app.Application
import dagger.Component
import m.bonnet.daggerexp.login.injection.LoginComponent
import m.bonnet.daggerexp.login.injection.LoginModule
import m.bonnet.daggerexp.scope.logged.LoggedComponent

@ApplicationScope
@Component(modules = [
    ApplicationModule::class,
    PreferencesModule::class
])
interface ApplicationComponent {
    fun inject(application: Application)

    fun plus(loginModule: LoginModule): LoginComponent

    fun logged(): LoggedComponent
}