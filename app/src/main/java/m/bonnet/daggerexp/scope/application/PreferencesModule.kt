package m.bonnet.daggerexp.scope.application

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class PreferencesModule {
    @Provides
    @ApplicationScope
    @Named("preferencesFileName")
    fun provideSharedPreferencesFileName() = "application.prefs"

    @Provides
    @ApplicationScope
    fun provideSharedPreferences(context: Context, @Named("preferencesFileName") preferencesFileName: String): SharedPreferences {
        return context.getSharedPreferences(preferencesFileName, Context.MODE_PRIVATE)
    }
}