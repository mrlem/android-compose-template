package org.mrlem.composesample.features.library.domain.usecase

import javax.inject.Inject
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class FormatDurationUseCase @Inject constructor() {

    operator fun invoke(duration: Duration): String {
        val builder = StringBuilder()
        var remaining = duration.inWholeSeconds.seconds

        remaining.inWholeDays
            .takeIf { it > 0 }
            ?.let {
                remaining -= it.days
                builder.append("${it}d ")
            }

        remaining.inWholeHours
            .takeIf { it > 0 }
            ?.let {
                remaining -= it.hours
                builder.append("${it}h ")
            }

        remaining.inWholeMinutes
            .let {
                remaining -= it.minutes
                builder.append("${it.toString().padStart(2, '0')}:")
            }

        remaining.inWholeSeconds
            .let {
                builder.append(it.toString().padStart(2, '0'))
            }

        return builder.toString()
    }
}