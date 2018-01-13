package com.tomorth.rxviews.views

import android.text.Editable
import android.widget.TextView
import com.tomorth.rxviews.observables.text.AfterTextChangedObservable
import com.tomorth.rxviews.observables.text.BeforeTextChangedObservable
import com.tomorth.rxviews.observables.text.TextChangeObservable
import io.reactivex.Observable

/**
 * Created by tomorth on 1/12/2018.
 */
object RxTextView {
    fun beforeText(t: TextView) : Observable<CharSequence?> = BeforeTextChangedObservable(t)

    fun textChanges(t: TextView) : Observable<CharSequence?> = TextChangeObservable(t)

    fun afterText(t: TextView) : Observable<Editable?> = AfterTextChangedObservable(t)
}