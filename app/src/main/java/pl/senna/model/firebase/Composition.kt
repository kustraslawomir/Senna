package pl.senna.model.firebase

import com.google.gson.annotations.SerializedName

class Composition {

    @SerializedName("id")
    var id: Int = 0
    @SerializedName("name")
    var name: String = ""
    @SerializedName("premium")
    var premium: Boolean = false
    @SerializedName("sounds")
    var sounds: List<String> = emptyList()
}
