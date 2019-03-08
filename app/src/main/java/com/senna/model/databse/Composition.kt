package com.senna.model.databse

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
class Composition : Parcelable {

    @PrimaryKey
    var id: Int = 0
    var name: String = ""
    var premium: Boolean = false

    @ColumnInfo(name ="is_public")
    var isPublic: Boolean = false

    var sounds: List<String> = emptyList()
}