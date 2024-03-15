package org.khip8emu.display


class ScreenBuffer {
    val screenHeight = 32
    val screenWidth = 64
    var pixelValues = Array<BooleanArray>(screenHeight) { BooleanArray(screenWidth) {false} }

    fun printPixelValuesAsScreen() {
        for ( y in 0..<screenHeight) {
            println()
            for ( x in 0..<screenWidth) {
                val pixel = if (pixelValues[y][x]) {
                    1
                } else {
                    0
                }
                print("$pixel ")
            }
        }
    }

    fun printPixelValuesAsArray() {
        print(pixelValues)
    }

    fun setPixelValue(yOffset: Int, xOffset: Int, value: Boolean) {
        pixelValues[yOffset][xOffset] = value
    }

    fun toggle(yOffset: Int, xOffset: Int) {
        pixelValues[yOffset][xOffset]  = !pixelValues[yOffset][xOffset]
    }

}