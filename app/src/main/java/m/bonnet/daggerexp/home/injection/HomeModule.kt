package m.bonnet.daggerexp.home.injection

import dagger.Module
import dagger.Provides
import m.bonnet.daggerexp.home.*
import m.bonnet.daggerexp.home.repository.HomeRepository

@Module
class HomeModule(private val homeActivity: HomeActivity) {

    @Provides
    @HomeScope
    fun provideView(): HomeView {
        return homeActivity
    }

    @Provides
    @HomeScope
    fun provideController(homeInteractor: HomeInteractor): HomeController {
        return HomeControllerImpl(homeInteractor)
    }

    @Provides
    @HomeScope
    fun provideInteractor(homePresenter: HomePresenter, homeRepository: HomeRepository): HomeInteractor {
        return HomeInteractorImpl(homePresenter, homeRepository)
    }

    @Provides
    @HomeScope
    fun providePresenter(homeView: HomeView): HomePresenter {
        return HomePresenterImpl(homeView)
    }
}