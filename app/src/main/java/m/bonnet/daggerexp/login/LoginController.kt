package m.bonnet.daggerexp.login

import android.arch.lifecycle.LifecycleOwner
import m.bonnet.daggerexp.async.LifecycleAwareController

interface LoginController {
    fun handleLoginViewIntent(loginViewIntent: LoginViewIntent)
}

sealed class LoginViewIntent
data class PerformLoginViewIntent(val userName: String, val password: String) : LoginViewIntent()

class LoginControllerImpl(lifecycleOwner: LifecycleOwner,
                          private val loginInteractor: LoginInteractor) : LoginController, LifecycleAwareController(lifecycleOwner) {


    override fun handleLoginViewIntent(loginViewIntent: LoginViewIntent) {
        when (loginViewIntent) {
            is PerformLoginViewIntent -> {
                consumerActor(loginViewIntent) { (username, password) -> loginInteractor.performLogin(username, password) }
            }
        }
    }
}