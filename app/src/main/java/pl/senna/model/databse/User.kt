package pl.senna.model.databse

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.senna.repository.local.DefaultValues
import pl.senna.repository.local.TableNames.Companion.USER

@Entity(tableName = USER)
class User {

    @PrimaryKey
    var id: Int = 0

    var token: String = DefaultValues.DEFAULT_TOKEN
    var email: String = DefaultValues.DEFAULT_EMAIL
    var name: String? = DefaultValues.DEFAULT_NAME
}