package com.moez.QKSMS.interactor

import android.telephony.SmsMessage
import com.moez.QKSMS.model.Message
import com.moez.QKSMS.repository.CloudRepository
import io.reactivex.Flowable
import javax.inject.Inject

class CloudSend @Inject constructor(
    private val cloudRepository: CloudRepository
) : Interactor<CloudSend.Params>() {

    class Params(val messages: Array<SmsMessage>) //message wrapper class

    override fun buildObservable(params: Params): Flowable<*> {
        return Flowable.just(Unit)
                .doOnNext { cloudRepository.sendSentMessagesToCloud(params.messages) }
    }
}