package com.tomorth.rxviews

import android.view.View
import com.tomorth.rxviews.observables.clicks.LongClickObservable
import com.tomorth.rxviews.observables.clicks.SingleClickObservable
import io.reactivex.Observable

/**
 * Rx Bindings for general View actions
 */
object RxView {
    /**
     * Creates an Observable to subscribe to a view click
     * @param view The view to use
     * @return An observable to subscribe to the view click
     */
    fun clicks(view: View) : Observable<Any> = SingleClickObservable(view)

    /**
     * Creates an Observable to subscribe to a view long click
     * @param view The view to use
     * @return An observable to subscribe to the view long click
     */
    fun longClicks(view: View) : Observable<Any> = LongClickObservable(view)
}