package com.ingmicha.android.udemy.novo.compose.jetpackcomposeinstagram.login.data

import com.ingmicha.android.udemy.novo.compose.jetpackcomposeinstagram.login.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api: LoginService
) {
    suspend fun doLogin(email: String, password: String): Boolean {
        return api.doLogin(email, password)
    }
}