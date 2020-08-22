package com.moez.QKSMS.feature.firebaselogin

import com.moez.QKSMS.common.base.QkView
import io.reactivex.Observable

//The View interface will define the observables and subject for the activity
//The Activity will implement this interface
interface LoginView : QkView<LoginState> {

    val loginIntent: Observable<Unit>

    fun signInGoogle()
}