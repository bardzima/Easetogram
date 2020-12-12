package easetogram.image

class GrayscaleHistogramProcessor(
        override val pixelArray: ByteArray
) : ImageHistogramProcessor<GrayscaleHistogram>(pixelArray) {

    override val histogram: GrayscaleHistogram by lazy { GrayscaleHistogram() }

    override fun processRgb(red: Int, green: Int, blue: Int) {
        val gray = (red + green + blue) / 3
        histogram.array[gray]++
    }
}
