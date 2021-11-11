package io.github.grishaninvyacheslav.geekbrains_stopwatch.models.repositories

class TimestampRepository : TimestampProvider {
    override fun getMilliseconds(): Long {
        return System.currentTimeMillis()
    }
}