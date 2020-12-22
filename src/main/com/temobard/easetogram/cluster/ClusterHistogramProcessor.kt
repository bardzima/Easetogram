package com.temobard.easetogram.cluster

import com.temobard.easetogram.HistogramProcessor

class ClusterHistogramProcessor(
        private val dataArray: IntArray,
        private val sorted: Boolean = false
) : HistogramProcessor<ClusterHistogram> {

    override fun calculate(): ClusterHistogram? {
        if(dataArray.isEmpty()) return null

        val distinctArray = dataArray.distinct()
        val histogram = ClusterHistogram(distinctArray.count())

        dataArray.forEachIndexed { _, datum ->
            var clusterIndex: Int = histogram.clusters.indexOf(datum)
            if (clusterIndex < 0) {
                clusterIndex = histogram.clusters.indexOfFirst { it == 0 }

                if (clusterIndex >= 0) histogram.clusters[clusterIndex] = datum
            }

            if (clusterIndex >= 0) histogram.array[clusterIndex]++
        }

        return histogram
    }
}
