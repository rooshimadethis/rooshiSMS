package com.moez.QKSMS.receiver;

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.moez.QKSMS.interactor.ReceiveSms;

import javax.inject.Inject;

public class CloudSMSReceiver : BroadcastReceiver() {

    @Inject lateinit var receiveMessage: ReceiveSms

    override fun onReceive(p0: Context?, p1: Intent?) {
        TODO("Not yet implemented")
    }
}
