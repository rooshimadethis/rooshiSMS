package com.moez.QKSMS.feature.firebaselogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.jakewharton.rxbinding2.view.clicks
import com.moez.QKSMS.R
import com.moez.QKSMS.common.base.QkThemedActivity
import dagger.android.AndroidInjection
import com.moez.QKSMS.common.util.extensions.viewBinding
import com.moez.QKSMS.databinding.LoginActivityBinding
import javax.inject.Inject

//Activity still controls a lot of the functionality of the feature
class LoginActivity : QkThemedActivity(), LoginView {
    companion object {
        private const val signInRequestCode= 111
    }

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override val loginIntent by lazy { binding.googleSignInButton.clicks() }

    private val binding by viewBinding(LoginActivityBinding::inflate)
    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory)[LoginViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTitle(R.string.login_title)
        showBackButton(true)
        viewModel.bindView(this)

    }

    override fun signInGoogle() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

        val googleSignInClient = GoogleSignIn.getClient(this, gso)

        val signInIntent = googleSignInClient.signInIntent

        startActivityForResult(signInIntent, signInRequestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            signInRequestCode -> {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    val account = task.getResult(ApiException::class.java)!!
                    saveUserToFirebase(account.idToken!!)
                    Toast.makeText(this, "Sign in with Google successful!", Toast.LENGTH_SHORT).show()
                } catch (e: ApiException) {
                    Toast.makeText(this, "Sign in with Google failed!", Toast.LENGTH_SHORT).show()
                    Log.w("Failed login Google","signInResult:failed code=" + e.statusCode)
                }
            }
        }
    }

    private fun saveUserToFirebase(idToken: String) {
        val credential =  GoogleAuthProvider.getCredential(idToken, null)
        FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener(this) {task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Sign in with Firebase successful", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Sign in with Firebase failed", Toast.LENGTH_LONG).show()
                    }
                }
    }

    override fun render(state: LoginState) {
    }
}