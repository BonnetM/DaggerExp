package m.bonnet.daggerexp.scope.logged

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import m.bonnet.daggerexp.user.repository.UserInfoRepository
import m.bonnet.daggerexp.user.repository.UserInfoRepositoryImpl

@Module
class RepositoryModule {
    @Provides
    @LoggedScope
    fun provideUserInfoRepository(sharedPreferences: SharedPreferences): UserInfoRepository {
        return UserInfoRepositoryImpl(sharedPreferences)
    }
}