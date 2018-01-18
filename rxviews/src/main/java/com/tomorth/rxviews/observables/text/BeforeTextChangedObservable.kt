package com.tomorth.rxviews.observables.text

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

/**
 * Creates an Observable to subscribe to the beforeTextChanged event
 * @param view The TextView to use
 */
class BeforeTextChangedObservable(private val view: TextView) : Observable<CharSequence?>() {
    override fun subscribeActual(observer: Observer<in CharSequence?>?) {
        val listener = Listener(view, observer)
        view.addTextChangedListener(listener)
        observer?.onSubscribe(listener)
    }

    /**
     * Creates the Rx Listener
     * @param view The view to use
     * @param observer The observer for the Observable
     */
    class Listener(private val view: TextView, private val observer: Observer<in CharSequence?>?) : MainThreadDisposable(), TextWatcher {
        override fun afterTextChanged(p0: Editable?) = Unit

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            observer?.onNext(p0)
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        override fun onDispose() {
            view.removeTextChangedListener(this)
        }

    }

}