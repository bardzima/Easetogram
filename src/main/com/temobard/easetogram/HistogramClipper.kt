package com.temobard.easetogram

import kotlin.math.max

abstract class HistogramClipper(
        private val histogram: Histogram
) {

    fun getClippedHistogram(dropdownRateLimit: Float = DEFAULT_DROP_RATE_TOLERANCE): Histogram {
        val depth = histogram.array.size
        var clipping = 0
        var currentColumnHeight = 0

        for (i in 0 until depth) {
            val previousColumnHeight = if (i > 0) currentColumnHeight else getColumnHeight(i)
            currentColumnHeight = if (i > 0) getColumnHeight(i) else previousColumnHeight
            val nextColumnHeight = if (i < depth - 1) getColumnHeight(i + 1) else currentColumnHeight

            val dropRateLeft = getDropRate(currentColumnHeight, previousColumnHeight)
            val dropRateRight = getDropRate(currentColumnHeight, nextColumnHeight)

            if (
                    dropRateLeft < dropdownRateLimit &&
                    dropRateRight < dropdownRateLimit &&
                    clipping < currentColumnHeight
            ) clipping = max(currentColumnHeight, clipping)
        }

        return clipHistogramAndReturn(clipping)
    }

    private fun getDropRate(height1: Int, height2: Int): Float {
        return (height1 - height2).toFloat() / height1
    }

    protected abstract fun clipHistogramAndReturn(clipping: Int): Histogram
    protected abstract fun getColumnHeight(index: Int): Int

    companion object {
        const val DEFAULT_DROP_RATE_TOLERANCE = 0.5F
    }
}
