package easetogram.cluster

import easetogram.BaseHistogram

class ClusterHistogram(capacity: Int) : BaseHistogram(capacity) {
    val clusters = IntArray(capacity)
}
