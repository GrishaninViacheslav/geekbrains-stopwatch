package io.github.grishaninvyacheslav.geekbrains_stopwatch.models.interactors

import io.github.grishaninvyacheslav.geekbrains_stopwatch.*
import io.github.grishaninvyacheslav.geekbrains_stopwatch.models.repositories.TimestampRepository
import io.github.grishaninvyacheslav.geekbrains_stopwatch.models.use_cases.ElapsedTimeCalculator
import io.github.grishaninvyacheslav.geekbrains_stopwatch.models.use_cases.StopwatchListOrchestrator
import io.github.grishaninvyacheslav.geekbrains_stopwatch.models.use_cases.StopwatchStateCalculator
import io.github.grishaninvyacheslav.geekbrains_stopwatch.models.use_cases.TimestampMillisecondsFormatter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class StopwatchInteractor(private val timestampProvider: TimestampRepository) {
    private val stopwatchListOrchestrator = StopwatchListOrchestrator(
        StopwatchStateHolder(
            StopwatchStateCalculator(
                timestampProvider,
                ElapsedTimeCalculator(timestampProvider)
            ),
            ElapsedTimeCalculator(timestampProvider),
            TimestampMillisecondsFormatter()
        ),
        CoroutineScope(
            Dispatchers.Main
                    + SupervisorJob()
        )
    )

    val ticker = stopwatchListOrchestrator.ticker

    fun start() {
        stopwatchListOrchestrator.start()
    }

    fun pause() {
        stopwatchListOrchestrator.pause()
    }

    fun stop() {
        stopwatchListOrchestrator.stop()
    }
}