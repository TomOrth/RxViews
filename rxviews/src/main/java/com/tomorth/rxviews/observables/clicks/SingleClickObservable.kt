package com.tomorth.rxviews.observables.clicks

import android.view.View
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable
import com.tomorth.rxviews.internal.Notifcation

/**
 * Long Click Observable for a View's OnClickListener
 * @param view The view to be used
 * @return An Observable to subscribe to the OnClickListener
 */
class SingleClickObservable(private val view: View) : Observable<Any>() {
    override fun subscribeActual(observer: Observer<in Any>?) {
        val listener = Listener(view, observer)
        view.setOnClickListener(listener)
        observer?.onSubscribe(listener)
    }

    /**
     * Creates the Rx Listener
     * @param view The view to use
     * @param observer The observer for the Observable
     */
    class Listener(private val view: View, private val observer: Observer<in Any>?) : MainThreadDisposable(), View.OnClickListener {
        override fun onDispose() {
            view.setOnClickListener(null)
        }

        override fun onClick(p0: View?) {
            observer?.onNext(Notifcation.PRESSED)
        }

    }

}