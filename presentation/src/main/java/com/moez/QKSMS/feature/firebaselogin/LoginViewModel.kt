package com.moez.QKSMS.feature.firebaselogin

import com.moez.QKSMS.common.base.QkViewModel
import javax.inject.Inject

//The ViewModel is where the observables etc. are subscribed to and setup
class LoginViewModel @Inject constructor() : QkViewModel<LoginView, LoginState>(LoginState()) {

}