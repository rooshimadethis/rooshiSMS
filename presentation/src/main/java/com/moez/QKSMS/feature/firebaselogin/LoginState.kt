package com.moez.QKSMS.feature.firebaselogin

//The state is the data class which will hold values for the activity
//The binding will be updated based on the values in this state class
data class LoginState(
        val loggedIn: Boolean = false
)