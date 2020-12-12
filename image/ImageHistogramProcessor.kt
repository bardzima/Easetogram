package easetogram.image

import easetogram.HistogramProcessor

abstract class ImageHistogramProcessor<T : ImageHistogram>(
        open val pixelArray: ByteArray
) : HistogramProcessor<ImageHistogram> {

    protected abstract val histogram: T

    override fun calculate(): T? {
        if (pixelArray.isEmpty()) return null

        pixelArray.forEach { pixel ->
            val red = pixel.red()
            val green = pixel.green()
            val blue = pixel.blue()

            processRgb(red, green, blue)
        }

        return histogram
    }

    protected abstract fun processRgb(red: Int, green: Int, blue: Int)

    private fun Byte.red(): Int = this.shr(16) and 0xff

    private fun Byte.green(): Int = this.shr(8) and 0xff

    private fun Byte.blue(): Int = this.toInt() and 0xff

    private fun Byte.shr(bitCount: Int): Int = this.toInt() shr bitCount
}
