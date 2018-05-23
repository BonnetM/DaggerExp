package m.bonnet.daggerexp.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import m.bonnet.daggerexp.R
import m.bonnet.daggerexp.application.ExpApplication
import m.bonnet.daggerexp.home.injection.HomeModule
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeView {

    @Inject lateinit var homeController: HomeController

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ExpApplication).applicationComponent
                .logged()
                .plus(HomeModule(this))
                .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}
