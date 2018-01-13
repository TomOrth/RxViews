package com.tomorth.rxviews.observables.clicks

import android.view.View
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable
import com.tomorth.rxviews.internal.Notifcation

/**
 * Created by tomorth on 1/12/2018.
 */
class SingleClickObservable(private val view: View) : Observable<Any>() {
    override fun subscribeActual(observer: Observer<in Any>?) {
        val listener = Listener(view, observer)
        view.setOnClickListener(listener)
        observer?.onSubscribe(listener)
    }

    class Listener(private val view: View, private val observer: Observer<in Any>?) : MainThreadDisposable(), View.OnClickListener {
        override fun onDispose() {
            view.setOnClickListener(null)
        }

        override fun onClick(p0: View?) {
            observer?.onNext(Notifcation.PRESSED)
        }

    }

}