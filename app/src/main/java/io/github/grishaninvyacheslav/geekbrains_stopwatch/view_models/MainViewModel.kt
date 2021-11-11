package io.github.grishaninvyacheslav.geekbrains_stopwatch.view_models

import androidx.lifecycle.ViewModel
import io.github.grishaninvyacheslav.geekbrains_stopwatch.models.interactors.StopwatchInteractor
import io.github.grishaninvyacheslav.geekbrains_stopwatch.models.repositories.TimestampRepository

class MainViewModel(private val timestampProvider: TimestampRepository = TimestampRepository()) :
    ViewModel() {
    private val interactor = StopwatchInteractor(timestampProvider)

    fun getData() = interactor.ticker
    fun start() = interactor.start()
    fun pause() = interactor.pause()
    fun stop() = interactor.stop()
}