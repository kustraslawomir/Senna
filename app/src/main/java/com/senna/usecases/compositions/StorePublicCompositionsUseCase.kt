package com.senna.usecases.compositions

import com.senna.model.databse.Composition
import com.senna.model.firebase.FirebaseComposition
import com.senna.model.firebase.PublicCompositions
import com.senna.repository.local.DataBase
import javax.inject.Inject

class StorePublicCompositionsUseCase @Inject constructor(private val dataBase: DataBase) {

    fun storeCompositions(firebaseComposition: PublicCompositions, storeCompositionsCompleted: () -> Unit) {
        val compositions = firebaseComposition.compositions

        if (!compositions.isNullOrEmpty()) {
            clearCompositionsInDatabase()
            compositions.forEach { composition ->
                storeComposition(composition)
            }
        }
        storeCompositionsCompleted()
    }

    private fun clearCompositionsInDatabase() {
        dataBase.compositionDao().removePublicCompositions()
    }

    private fun storeComposition(composition: FirebaseComposition) {
        dataBase.compositionDao().insertComposition(Composition().apply {
            premium = composition.premium
            sounds = composition.sounds
            name = composition.name
            id = composition.id
            isPublic = true
        })
    }
}