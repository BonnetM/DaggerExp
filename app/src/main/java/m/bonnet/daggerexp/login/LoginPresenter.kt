package m.bonnet.daggerexp.login

interface LoginPresenter {
    fun presentError()
}

class LoginPresenterImpl(private val loginView: LoginView) : LoginPresenter {
    override fun presentError() {
        loginView.displayError()
    }
}