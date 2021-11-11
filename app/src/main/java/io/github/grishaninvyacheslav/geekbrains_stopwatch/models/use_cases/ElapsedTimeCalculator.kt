package io.github.grishaninvyacheslav.geekbrains_stopwatch.models.use_cases

import io.github.grishaninvyacheslav.geekbrains_stopwatch.StopwatchState
import io.github.grishaninvyacheslav.geekbrains_stopwatch.models.repositories.TimestampProvider

class ElapsedTimeCalculator(
    private val timestampProvider: TimestampProvider,
) {

    fun calculate(state: StopwatchState.Running): Long {
        val currentTimestamp = timestampProvider.getMilliseconds()
        val timePassedSinceStart = if (currentTimestamp > state.startTime) {
            currentTimestamp - state.startTime
        } else {
            0
        }
        return timePassedSinceStart + state.elapsedTime
    }
}