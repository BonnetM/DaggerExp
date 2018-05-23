package m.bonnet.daggerexp.home.injection

import dagger.Subcomponent
import m.bonnet.daggerexp.home.HomeActivity

@HomeScope
@Subcomponent(modules = [
    HomeModule::class,
    RepositoryModule::class
])
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
}