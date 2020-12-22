package com.temobard.easetogram.image

import com.temobard.easetogram.BaseHistogram

abstract class ImageHistogram : BaseHistogram(DEFAULT_COLOR_DEPTH) {
    companion object {
        const val DEFAULT_COLOR_DEPTH = 256
    }
}
