package pl.senna.model

sealed class RequestState {

    object DEFAULT : RequestState()
    object SUCCESS : RequestState()
    object ERROR : RequestState()
}