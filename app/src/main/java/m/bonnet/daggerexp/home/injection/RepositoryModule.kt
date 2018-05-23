package m.bonnet.daggerexp.home.injection

import dagger.Module
import dagger.Provides
import m.bonnet.daggerexp.home.repository.HomeRepository
import m.bonnet.daggerexp.home.repository.HomeRepositoryImpl
import m.bonnet.daggerexp.user.repository.UserInfoRepository

@Module
class RepositoryModule {
    @HomeScope
    @Provides
    fun provideHomeRepository(userInfoRepository: UserInfoRepository): HomeRepository {
        return HomeRepositoryImpl(userInfoRepository)
    }
}