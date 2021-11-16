package com.tamimattafi.pizza.android.presentation.core.mvvm

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.Disposable

class LifecycleObserver<T : Any>(
    private val observable: Flowable<T>,
    private val onNext: (T) -> Unit,
    private val onError: (Throwable) -> Unit
) : DefaultLifecycleObserver {

    private var disposable: Disposable? = null

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        disposable = observable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onNext, onError)
    }

    override fun onPause(owner: LifecycleOwner) {
        disposable?.dispose()
        super.onPause(owner)
    }
}