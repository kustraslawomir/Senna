package com.senna.usecases.compositions

import com.senna.model.databse.Composition
import com.senna.repository.local.DataBase
import javax.inject.Inject

class GetStoredCompositionsUseCase @Inject constructor(private val dataBase: DataBase) {

    fun getCompositions(setCompositions: (List<Composition>) -> Unit) {
        val compositions = dataBase.compositionDao().compositions
        if (compositions != null)
            setCompositions(compositions)
    }

    fun compositionsAreNullOrEmpty() = dataBase.compositionDao().compositions.isNullOrEmpty()
}