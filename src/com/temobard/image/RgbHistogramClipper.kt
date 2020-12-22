package easetogram.image

import easetogram.HistogramClipper
import java.lang.Integer.max

class RgbHistogramClipper(private val histogram: RgbHistogram) : HistogramClipper(histogram) {
    override fun clipHistogramAndReturn(clipping: Int): ImageHistogram =
            RgbHistogram().apply {
                histogram.array.forEachIndexed { index, _ ->
                    histogram.redArray[index] = histogram.redArray[index].coerceAtMost(clipping)
                    histogram.greenArray[index] = histogram.greenArray[index].coerceAtMost(clipping)
                    histogram.blueArray[index] = histogram.blueArray[index].coerceAtMost(clipping)
                }
            }

    override fun getColumnHeight(index: Int): Int {
        return max(
                max(
                        histogram.redArray[index],
                        histogram.greenArray[index]
                ), histogram.blueArray[index])
    }
}
