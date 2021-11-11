package io.github.grishaninvyacheslav.geekbrains_stopwatch.models.repositories

interface TimestampProvider {
    fun getMilliseconds(): Long
}