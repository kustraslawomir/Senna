package com.senna.model.firebase

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PublicCompositions {

    @SerializedName("compositions")
    @Expose
    var compositions: List<FirebaseComposition>? = null

}