package com.moez.QKSMS.repository

import android.telephony.SmsMessage
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CloudRepositoryImpl @Inject constructor() : CloudRepository {

    override fun sendSentMessagesToCloud(messages: Array<SmsMessage>) {

    }
}

