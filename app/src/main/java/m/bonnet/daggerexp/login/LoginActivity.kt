package m.bonnet.daggerexp.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import m.bonnet.daggerexp.R
import m.bonnet.daggerexp.application.ExpApplication
import m.bonnet.daggerexp.login.injection.LoginModule
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginView {

    @Inject
    lateinit var controller: LoginController

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ExpApplication)
                .applicationComponent
                .plus(LoginModule(this))
                .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()
        passwordEditText.setOnEditorActionListener { _, action, _ ->
            if (action == EditorInfo.IME_ACTION_DONE) {
                controller.handleLoginViewIntent(PerformLoginViewIntent(loginEditText.text.toString(), passwordEditText.text.toString()))
                true
            } else {
                false
            }
        }
    }

    override fun displayError() {
        launch(UI) {
            Toast.makeText(this@LoginActivity, "Petite erreur !", Toast.LENGTH_SHORT).show()
        }
    }

}
