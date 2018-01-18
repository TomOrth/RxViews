package com.tomorth.rxviews.views

import android.text.Editable
import android.widget.TextView
import com.tomorth.rxviews.observables.text.AfterTextChangedObservable
import com.tomorth.rxviews.observables.text.BeforeTextChangedObservable
import com.tomorth.rxviews.observables.text.TextChangeObservable
import io.reactivex.Observable

/**
 * Rx Bindings for TextView actions
 */
object RxTextView {
    /**
     * Creates an Observable to subscribe to get the before text changed data
     * @param t The textview
     * @returns An Observable to subscribe and get the before text data
     */
    fun beforeText(t: TextView) : Observable<CharSequence?> = BeforeTextChangedObservable(t)

    /**
     * Creates an Observable to subscribe to get text when the text change
     * @param t The textview
     * @returns An Observable to subscribe and get the text when it changes
     */
    fun textChanges(t: TextView) : Observable<CharSequence?> = TextChangeObservable(t)

    /**
     * Creates an Observable to subscribe to get the after text data
     * @param t The textview
     * @returns An Observable to subscribe and get the after text data
     */
    fun afterText(t: TextView) : Observable<Editable?> = AfterTextChangedObservable(t)
}