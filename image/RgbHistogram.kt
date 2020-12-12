package easetogram.image

class RgbHistogram : ImageHistogram() {
    val redArray = IntArray(DEFAULT_COLOR_DEPTH)
    val greenArray = IntArray(DEFAULT_COLOR_DEPTH)
    val blueArray get() = array
}
