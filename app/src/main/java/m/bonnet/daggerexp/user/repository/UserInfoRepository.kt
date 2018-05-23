package m.bonnet.daggerexp.user.repository

import android.content.SharedPreferences

interface UserInfoRepository {
}

class UserInfoRepositoryImpl(sharedPreferences: SharedPreferences) : UserInfoRepository