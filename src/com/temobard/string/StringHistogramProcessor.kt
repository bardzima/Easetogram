package easetogram.string

import easetogram.HistogramProcessor

class StringHistogramProcessor(
        private val stringArray: ArrayList<String>
) : HistogramProcessor<StringHistogram> {

    override fun calculate(): StringHistogram? {
        if (stringArray.isEmpty()) return null

        val distinctArray = stringArray.distinct()
        val histogram = StringHistogram(distinctArray.count())

        stringArray.forEachIndexed { _, label ->
            val labelIndex: Int = histogram.labels.indexOf(label)
            if (labelIndex < 0) histogram.labels.add(label)
            else histogram.labels[labelIndex] = label

            val arrayIndex = if (labelIndex < 0) histogram.labels.size - 1 else labelIndex
            histogram.array[arrayIndex]++
        }

        return histogram
    }
}
