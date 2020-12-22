package com.temobard.easetogram.cluster

import com.temobard.easetogram.BaseHistogram

class ClusterHistogram(capacity: Int) : BaseHistogram(capacity) {
    val clusters = IntArray(capacity)
}
