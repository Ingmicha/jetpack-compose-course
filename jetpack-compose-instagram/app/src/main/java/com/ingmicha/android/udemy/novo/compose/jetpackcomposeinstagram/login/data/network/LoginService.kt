package com.ingmicha.android.udemy.novo.compose.jetpackcomposeinstagram.login.data.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) {

    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default

    suspend fun doLogin(user: String, password: String): Boolean {
        return withContext(defaultDispatcher) {
            val response = loginClient.doLogin()
            response.body()?.success ?: false
        }
    }
}