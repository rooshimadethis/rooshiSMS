package com.moez.QKSMS.repository

import android.telephony.SmsMessage
import com.moez.QKSMS.model.Message

interface CloudRepository {

    //will given a message
    fun sendSentMessagesToCloud(messages: Array<SmsMessage>)

}