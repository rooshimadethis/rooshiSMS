package com.moez.QKSMS.feature.firebaselogin

import androidx.lifecycle.ViewModel
import com.moez.QKSMS.injection.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class LoginActivityModule {

    @Provides
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun provideLoginViewModel(viewModel: LoginViewModel): ViewModel = viewModel
}