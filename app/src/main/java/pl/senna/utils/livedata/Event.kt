package pl.senna.utils.livedata

open class Event<out T>(private val content: T) {

    private var hasBeenHandled = false

    fun shouldBeHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}