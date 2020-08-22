package com.moez.QKSMS.repository

import android.telephony.SmsMessage
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CloudRepositoryImpl @Inject constructor() : CloudRepository {

    data class User(
            //not sure if that is persistent. probably not
            //i might not even have to save this. just get firebaseauth
            var googleAccount: GoogleSignInAccount? = null
    )

    override fun sendSentMessagesToCloud(messages: Array<SmsMessage>) {
        FirebaseAuth.getInstance().currentUser?.let { Log.w("in CloudRepImpl", "it worked!") }
    }
}

