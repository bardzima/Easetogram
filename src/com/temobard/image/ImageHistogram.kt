package easetogram.image

import easetogram.BaseHistogram

abstract class ImageHistogram : BaseHistogram(DEFAULT_COLOR_DEPTH) {
    companion object {
        const val DEFAULT_COLOR_DEPTH = 256
    }
}
