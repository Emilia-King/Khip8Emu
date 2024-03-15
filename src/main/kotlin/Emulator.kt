package org.khip8emu

import org.khip8emu.display.ScreenBuffer
import org.khip8emu.input.Input
import org.khip8emu.memory.Memory
import org.khip8emu.opcode.OpCode
import org.khip8emu.registers.Registers
import org.khip8emu.timers.DelayTimer
import org.khip8emu.timers.SoundTimer

class Emulator {
    var input: Input = Input()
    var memory: Memory = Memory()
    var opCode: OpCode = OpCode()
    var registers: Registers = Registers()
    var delayTimer: DelayTimer = DelayTimer()
    var soundTimer: SoundTimer = SoundTimer()
    var screenBuffer: ScreenBuffer = ScreenBuffer()

    private var emulationShouldRun: Boolean = true

    fun startEmulation() {
        val timerFrequency = 1000L / 60 // 60Hz in milliseconds
        var lastTimerUpdate = System.currentTimeMillis()
        var loopCounter = 0
        var startTime = System.nanoTime()
        val frequencyCheckInterval = 1_000_000_000L // 1 second in nanoseconds

        while (emulationShouldRun) {
                loopCounter++

                val currentTime = System.nanoTime()
                if (currentTime - startTime >= frequencyCheckInterval) {
                    // Calculate and print the frequency
                    val frequency = loopCounter / ((currentTime - startTime) / 1_000_000_000.0)
                    println("Current Hz: $frequency")

                    // Reset counter and start time for the next calculation
                    loopCounter = 0
                    startTime = currentTime
                }

                // Optional: sleep or wait logic to control loop speed
            val currentTimemili = System.currentTimeMillis()
            val elapsedTime = currentTimemili - lastTimerUpdate

            // Execute a cycle of CPU instructions (opcode fetch, decode, execute)
            executeCpuCycle()

            // Update timers at 60Hz
            if (elapsedTime >= timerFrequency) {
                updateTimers()
                lastTimerUpdate = currentTimemili
            }
            Thread.sleep(17)
        }
    }

    private fun executeCpuCycle() {

    }

    private fun updateTimers() {
        delayTimer.decrement()
        soundTimer.decrement()
    }
}