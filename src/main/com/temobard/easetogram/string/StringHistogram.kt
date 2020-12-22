package com.temobard.easetogram.string

import com.temobard.easetogram.BaseHistogram

class StringHistogram(capacity: Int) : BaseHistogram(capacity) {
    val labels = ArrayList<String>(capacity)
}
