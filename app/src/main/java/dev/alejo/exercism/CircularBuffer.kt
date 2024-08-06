package dev.alejo.exercism

class EmptyBufferException : Exception()

class BufferFullException : Exception()

class CircularBuffer<T>(private val size: Int) {
    private var bufferData = MutableList<T?>(size) { null }
    private var readIndex: Int = 0
    private var writeIndex: Int = 0

    fun read() : T {
        if (bufferData.any { it != null }) {
            val valueIndex = bufferData[readIndex]
            readIndex++
            return valueIndex ?: throw EmptyBufferException()
        } else {
            throw EmptyBufferException()
        }
    }

    fun write(value: T) {
        if (bufferData.contains(null)) {
            bufferData[writeIndex] = value
            // If the write index is the last position of the buffer
            increaseWriteIndex()
        } else {
            throw BufferFullException()
        }
    }

    fun overwrite(value: T) {
        bufferData[writeIndex] = value
        increaseWriteIndex()
    }

    fun clear() {
        bufferData.replaceAll { null }
        writeIndex = 0
        readIndex = 0
    }

    private fun increaseWriteIndex() {
        writeIndex = if (writeIndex == (size - 1)) 0 else writeIndex+1
    }
}