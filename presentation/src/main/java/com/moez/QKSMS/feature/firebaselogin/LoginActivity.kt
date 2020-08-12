package com.moez.QKSMS.feature.firebaselogin

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.moez.QKSMS.R
import com.moez.QKSMS.common.base.QkThemedActivity
import dagger.android.AndroidInjection
import com.moez.QKSMS.common.util.extensions.viewBinding
import com.moez.QKSMS.databinding.LoginActivityBinding
import javax.inject.Inject

//Activity still controls a lot of the functionality of the feature
class LoginActivity : QkThemedActivity(), LoginView {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

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

    override fun render(state: LoginState) {
    }
}