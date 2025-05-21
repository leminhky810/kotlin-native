package org.minhky.kmpnative

import dagger.hilt.android.lifecycle.HiltViewModel
import org.minhky.kmpnative.domain.usecase.ObserverFruittesUseCase
import org.minhky.kmpnative.viewmodel.MainViewModel
import javax.inject.Inject

@HiltViewModel
class MainConsumerViewModel @Inject constructor(
    observerFruittesUseCase: ObserverFruittesUseCase
) : MainViewModel(observerFruittesUseCase) {



}