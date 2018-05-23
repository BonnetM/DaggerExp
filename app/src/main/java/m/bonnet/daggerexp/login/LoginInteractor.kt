package m.bonnet.daggerexp.login

interface LoginInteractor {
    fun performLogin(userName: String, password: String)
}

class LoginInteractorImpl(private val loginPresenter: LoginPresenter) : LoginInteractor {
    override fun performLogin(userName: String, password: String) {
        loginPresenter.presentError()
    }
}