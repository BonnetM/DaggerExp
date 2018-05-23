package m.bonnet.daggerexp.home.repository

import m.bonnet.daggerexp.user.repository.UserInfoRepository

interface HomeRepository

class HomeRepositoryImpl(userInfoRepository: UserInfoRepository) : HomeRepository
