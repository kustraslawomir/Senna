package com.senna.usecases

import com.senna.model.databse.Composition
import com.senna.model.firebase.PublicCompositions
import com.senna.repository.local.DataBase
import javax.inject.Inject

class StorePublicCompositionsUseCase @Inject constructor(private val dataBase: DataBase) {

    fun storeCompositions(firebaseComposition: PublicCompositions, startSplashScreenDelay: () -> Unit) {
        val compositions = firebaseComposition.compositions
        if (!compositions.isNullOrEmpty()) {

            dataBase.compositionDao().removePublicCompositions()

            compositions.forEach { composition ->
                dataBase.compositionDao().insertComposition(Composition().apply {
                    premium = composition.premium
                    sounds = composition.sounds
                    name = composition.name
                    id = composition.id
                    isPublic = true
                })
            }
        }
        startSplashScreenDelay()
    }
}