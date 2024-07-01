package com.gojingamnae.freshmate.ui.sign

import androidx.annotation.RawRes
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.AmplifyConfiguration
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import android.util.Log
import android.content.Context

class AmplifyManager(
    private val context: Context,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    fun configureAmplify(@RawRes configResourceId: Int) {
        try {
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Amplify.configure(AmplifyConfiguration.fromConfigFile(context, configResourceId), context)
        } catch (e: Exception) {
            Log.e(TAG, "amplify configure error", e)
        }
    }

    // ...

    companion object {
        private val TAG: String = AmplifyManager::class.java.simpleName
    }
}