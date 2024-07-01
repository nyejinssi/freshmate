package com.gojingamnae.freshmate.ui.sign

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.amplifyframework.auth.AuthProvider
import com.amplifyframework.auth.result.step.AuthSignInStep
import com.amplifyframework.core.Amplify
import com.gojingamnae.freshmate.MainActivity
import com.gojingamnae.freshmate.R

class SignFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign, container, false)

        val signInButton: Button = view.findViewById(R.id.btnSignIn)
        signInButton.setOnClickListener { signInWithGoogle() }

        return view
    }

    private fun signInWithGoogle() {
        Amplify.Auth.signInWithSocialWebUI(AuthProvider.google(), requireActivity(),
            { result ->
                if (result.nextStep.signInStep == AuthSignInStep.DONE) {
                    navigateToMainActivity()
                } else {
                    showToast("Sign in not complete")
                }
            },
            { error ->
                showToast("Sign in failed: ${error.message}")
            }
        )
    }

    private fun navigateToMainActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }

    private fun showToast(message: String) {
        requireActivity().runOnUiThread {
            Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
        }
    }
}
