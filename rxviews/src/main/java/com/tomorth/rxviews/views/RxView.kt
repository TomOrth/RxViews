package com.tomorth.rxviews

import android.view.View
import com.tomorth.rxviews.observables.clicks.LongClickObservable
import com.tomorth.rxviews.observables.clicks.SingleClickObservable
import io.reactivex.Observable

/**
 * Created by tomorth on 1/12/2018.
 */
object RxView {
    fun clicks(view: View) : Observable<Any> = SingleClickObservable(view)

    fun longClicks(view: View) : Observable<Any> = LongClickObservable(view)
}