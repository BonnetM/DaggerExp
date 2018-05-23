package m.bonnet.daggerexp.login.injection

import dagger.Subcomponent
import m.bonnet.daggerexp.login.LoginActivity

@LoginScope
@Subcomponent(modules = [
    LoginModule::class,
    ValidatorModule::class,
    RepositoryModule::class
])
interface LoginComponent {
    fun inject(loginActivity: LoginActivity)
}