package com.temobard.easetogram.image

class RgbHistogramProcessor(
        override val pixelArray: ByteArray
) : ImageHistogramProcessor<RgbHistogram>(pixelArray) {

    override val histogram: RgbHistogram by lazy { RgbHistogram() }

    override fun processRgb(red: Int, green: Int, blue: Int) {
        histogram.redArray[red]++
        histogram.greenArray[green]++
        histogram.blueArray[blue]++
    }
}
