package pl.senna.utils.livedata

open class Event<out T>(private val value: T) {

    private var hasBeenHandled = false

    fun shouldBeHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            value
        }
    }

    fun peekContent(): T = value
}