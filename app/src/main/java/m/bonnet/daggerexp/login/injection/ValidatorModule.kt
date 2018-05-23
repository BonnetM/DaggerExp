package m.bonnet.daggerexp.login.injection

import dagger.Module
import dagger.Provides
import m.bonnet.daggerexp.login.validator.LoginValidator
import m.bonnet.daggerexp.login.validator.LoginValidatorImpl

@Module
class ValidatorModule {
    @LoginScope
    @Provides
    fun provideValidator(): LoginValidator {
        return LoginValidatorImpl()
    }
}