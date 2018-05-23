package m.bonnet.daggerexp.scope.logged

import dagger.Subcomponent
import m.bonnet.daggerexp.home.injection.HomeComponent
import m.bonnet.daggerexp.home.injection.HomeModule

@LoggedScope
@Subcomponent(modules = [
    RepositoryModule::class
])
interface LoggedComponent {
    fun plus(homeModule: HomeModule): HomeComponent
}