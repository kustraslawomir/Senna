package com.senna.model

sealed class PlayerState {
    object Paused : PlayerState()
    object Playing : PlayerState()
}