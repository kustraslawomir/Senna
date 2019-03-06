package com.senna.usecases

import com.senna.model.databse.Composition
import com.senna.repository.local.DataBase
import javax.inject.Inject

class GetStoredPublicCompositionsUseCase @Inject constructor(private val dataBase: DataBase) {

    fun getCompositions(setCompositions : (List<Composition>) -> Unit){
        val compositions = dataBase.compositionDao().compositions
        setCompositions(compositions)
    }
}