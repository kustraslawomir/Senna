package com.senna.model.databse

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Composition {

    @PrimaryKey
    var id: Int = 0
    var name: String = ""
    var premium: Boolean = false
    var sounds: List<String> = emptyList()
}