package easetogram.string

import easetogram.BaseHistogram

class StringHistogram(capacity: Int) : BaseHistogram(capacity) {
    val labels = ArrayList<String>(capacity)
}
