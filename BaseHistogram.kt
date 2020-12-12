package easetogram

abstract class BaseHistogram(range: Int) : Histogram {
    override var array: IntArray = IntArray(range)
}
