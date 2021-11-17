package com.tamimattafi.pizza.android.presentation.utils

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.processors.FlowableProcessor

fun Completable.subscribeToProcessor(processor: FlowableProcessor<Unit>) =
    toSingleDefault(Unit)
        .toFlowable()
        .subscribe(processor::onNext, processor::onError)