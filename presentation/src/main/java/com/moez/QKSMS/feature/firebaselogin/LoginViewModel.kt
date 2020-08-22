package com.moez.QKSMS.feature.firebaselogin

import com.moez.QKSMS.common.base.QkViewModel
import com.uber.autodispose.android.lifecycle.scope
import com.uber.autodispose.autoDisposable
import javax.inject.Inject

//The ViewModel is where the observables etc. are subscribed to, setup, and sometimes handled
class LoginViewModel @Inject constructor() : QkViewModel<LoginView, LoginState>(LoginState()) {
    //private val user: Firebase

    override fun bindView(view: LoginView) {
        super.bindView(view)
        view.loginIntent
                .autoDisposable(view.scope())
                .subscribe {
                    //launch google sign in activity
                    view.signInGoogle()
                }
    }

}