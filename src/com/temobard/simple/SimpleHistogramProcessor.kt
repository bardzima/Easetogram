package easetogram.simple

import easetogram.HistogramProcessor

class SimpleHistogramProcessor(
        private val dataArray: IntArray
) : HistogramProcessor<SimpleHistogram> {

    override fun calculate(): SimpleHistogram? = dataArray.maxOrNull()?.let {
        val histogram = SimpleHistogram(it)

        dataArray.forEach { dataPoint ->
            histogram.array[dataPoint - 1]++
        }

        histogram
    }
}
