package dev.alejo.exercism

class EmptyBufferException : Exception()

class BufferFullException : Exception()

class CircularBuffer<T>(private val size: Int) {
    private var bufferData = MutableList<T?>(size) { null }
    private var readIndex: Int = 0
    private var writeIndex: Int = 0
    private var elementsNotRead: Int = 0

    fun read() : T {
        if (elementsNotRead == 0) {
            throw EmptyBufferException()
        } else {
            if (bufferData.any { it != null }) {
                val valueIndex = bufferData[readIndex]
                readIndex = if (readIndex == (size - 1)) { 0 } else { readIndex + 1 }
                elementsNotRead--
                return valueIndex ?: throw EmptyBufferException()
            } else {
                throw EmptyBufferException()
            }
        }
    }

    fun write(value: T) {
        if (!bufferData.contains(null) && elementsNotRead > 0 && (writeIndex == readIndex)) {
            throw BufferFullException()
        } else {
            bufferData[writeIndex] = value
            elementsNotRead++
            // If the write index is the last position of the buffer
            increaseWriteIndex()
        }
    }

    fun overwrite(value: T) {
        if (bufferData.contains(null)) {
            write(value)
        } else {
            bufferData[writeIndex] = value
            increaseWriteIndex()
            readIndex = writeIndex
        }
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