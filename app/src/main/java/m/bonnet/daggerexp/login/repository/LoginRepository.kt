package m.bonnet.daggerexp.login.repository

import android.content.SharedPreferences

interface LoginRepository
class LoginRepositoryImpl(sharedPreferences: SharedPreferences) : LoginRepository