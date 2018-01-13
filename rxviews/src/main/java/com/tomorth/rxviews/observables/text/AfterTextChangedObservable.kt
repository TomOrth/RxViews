package com.tomorth.rxviews.observables.text

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

/**
 * Created by tomorth on 1/12/2018.
 */
class AfterTextChangedObservable(private val view: TextView) : Observable<Editable?>() {
    override fun subscribeActual(observer: Observer<in Editable?>?) {
        val listener = Listener(view, observer)
        view.addTextChangedListener(listener)
        observer?.onSubscribe(listener)
    }

    class Listener(private val view: TextView, private val observer: Observer<in Editable?>?) : MainThreadDisposable(), TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            observer?.onNext(p0)
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        override fun onDispose() {
            view.removeTextChangedListener(this)
        }

    }

}