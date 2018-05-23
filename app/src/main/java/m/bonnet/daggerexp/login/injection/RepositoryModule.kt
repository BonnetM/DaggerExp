package m.bonnet.daggerexp.login.injection

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import m.bonnet.daggerexp.login.repository.LoginRepository
import m.bonnet.daggerexp.login.repository.LoginRepositoryImpl

@Module
class RepositoryModule {
    @LoginScope
    @Provides
    fun provideLoginRepository(sharedPreferences: SharedPreferences): LoginRepository {
        return LoginRepositoryImpl(sharedPreferences)
    }
}