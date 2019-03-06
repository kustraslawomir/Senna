package com.senna.usecases

import com.senna.model.databse.Composition
import com.senna.model.firebase.PublicCompositions
import com.senna.repository.local.DataBase
import javax.inject.Inject

class StorePublicCompositionsUseCase @Inject constructor(private val dataBase: DataBase) {

    fun storeCompositions(firebaseComposition: PublicCompositions, startSplashScreenDelay: () -> Unit) {
        val compositions = firebaseComposition.compositions
        compositions?.forEach { composition ->
            dataBase.compositionDao().insertComposition(Composition().apply {
                id = composition.id
                name = composition.name
                premium = composition.premium
                sounds = composition.sounds
            })
        }
        startSplashScreenDelay()
    }
}