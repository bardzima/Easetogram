package com.temobard.easetogram.simple

import com.temobard.easetogram.Histogram
import com.temobard.easetogram.HistogramClipper
import java.lang.Integer.min

class SimpleHistogramClipper(private val histogram: SimpleHistogram) : HistogramClipper(histogram) {

    override fun clipHistogramAndReturn(clipping: Int): Histogram =
            SimpleHistogram(histogram.array.size).apply {
                histogram.array.forEachIndexed { index, _ ->
                    array[index] = min(clipping, histogram.array[index])
                }
            }

    override fun getColumnHeight(index: Int): Int = histogram.array[index]
}
