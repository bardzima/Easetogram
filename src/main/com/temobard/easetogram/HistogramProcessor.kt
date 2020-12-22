package com.temobard.easetogram

interface HistogramProcessor<T : Histogram> {
    fun calculate(): T?
}
