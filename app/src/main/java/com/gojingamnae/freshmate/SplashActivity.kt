package com.gojingamnae.freshmate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import android.util.Log
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.Amplify
import com.amplifyframework.AmplifyException
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.gojingamnae.freshmate.ui.sign.SignFragment

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // AWS Amplify 초기화
        try {
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Amplify.configure(applicationContext)
            Log.i("SplashActivity", "Initialized Amplify")

            // Check if user is already signed in
            Amplify.Auth.fetchAuthSession(
                { result ->
                    if (result.isSignedIn) {
                        navigateToMainActivity()
                    } else {
                        showSignFragment()
                    }
                },
                { error ->
                    Log.e("SplashActivity", "Auth session fetch failed", error)
                    showSignFragment()
                }
            )
        } catch (error: AmplifyException) {
            Log.e("SplashActivity", "Could not initialize Amplify", error)
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showSignFragment() {
        supportFragmentManager.commit {
            replace(R.id.splash, SignFragment())
        }
    }
}
