package m.bonnet.daggerexp.login.injection

import dagger.Module
import dagger.Provides
import m.bonnet.daggerexp.login.*

@Module
class LoginModule(private val loginActivity: LoginActivity) {

    @LoginScope
    @Provides
    fun provideView(): LoginView {
        return loginActivity
    }

    @LoginScope
    @Provides
    fun provideController(loginInteractor: LoginInteractor): LoginController {
        return LoginControllerImpl(loginActivity, loginInteractor)
    }

    @LoginScope
    @Provides
    fun provideInteractor(loginPresenter: LoginPresenter): LoginInteractor {
        return LoginInteractorImpl(loginPresenter)
    }

    @LoginScope
    @Provides
    fun providePresenter(loginView: LoginView): LoginPresenter {
        return LoginPresenterImpl(loginView)
    }
}