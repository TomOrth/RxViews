package com.tomorth.rxviews.observables.clicks

import android.view.View
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable
import com.tomorth.rxviews.internal.Notifcation

/**
 * Created by tomorth on 1/12/2018.
 */
class LongClickObservable(private val view: View) : Observable<Any>() {
    override fun subscribeActual(observer: Observer<in Any>?) {
        val listener = Listener(view, observer)
        view.setOnLongClickListener(listener)
        observer?.onSubscribe(listener)
    }

    class Listener(private val view: View, private val observer: Observer<in Any>?) : MainThreadDisposable(), View.OnLongClickListener {

        override fun onDispose() {
            view.setOnLongClickListener(null)
        }

        override fun onLongClick(p0: View?): Boolean {
            observer?.onNext(Notifcation.PRESSED)
            return true
        }



    }

}