package m.bonnet.daggerexp.home

import m.bonnet.daggerexp.home.repository.HomeRepository

interface HomeInteractor

class HomeInteractorImpl(homeController: HomePresenter, homeRepository: HomeRepository) : HomeInteractor