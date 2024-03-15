package org.khip8emu.timers

class SoundTimer {
    private var soundValue = 0
    fun decrement() {
        soundValue--
    }

    fun isTimerZero(): Boolean {
        return soundValue == 0
    }
}