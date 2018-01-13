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
class TextChangeObservable(private val view: TextView) : Observable<CharSequence?>() {
    override fun subscribeActual(observer: Observer<in CharSequence?>?) {
        val listener = Listener(view, observer)
        view.addTextChangedListener(listener)
        observer?.onSubscribe(listener)
    }

    class Listener(private val view: TextView, private val observer: Observer<in CharSequence?>?) : MainThreadDisposable(), TextWatcher {
        override fun afterTextChanged(p0: Editable?) = Unit

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            observer?.onNext(p0)
        }

        override fun onDispose() {
            view.removeTextChangedListener(this)
        }

    }

}