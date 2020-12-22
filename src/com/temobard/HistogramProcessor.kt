package easetogram

interface HistogramProcessor<T : Histogram> {
    fun calculate(): T?
}
