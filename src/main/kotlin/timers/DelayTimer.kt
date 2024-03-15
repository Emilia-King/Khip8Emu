package org.khip8emu.timers

class DelayTimer {
    private var delayValue = 0
    fun decrement() {
        delayValue--
    }

    fun isTimerZero(): Boolean {
        return delayValue == 0
    }
}