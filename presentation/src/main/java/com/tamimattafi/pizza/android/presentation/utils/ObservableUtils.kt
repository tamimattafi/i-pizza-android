package com.tamimattafi.pizza.android.presentation.utils

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.processors.FlowableProcessor

fun Completable.subscribeToProcessor(processor: FlowableProcessor<Unit>): Disposable =
    subscribe({
        processor.onNext(Unit)
    }, processor::onError)