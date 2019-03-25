package com.senna.model.fetchstates

import com.senna.model.firebase.PublicCompositions

sealed class GetCompositionsNetworkState {

    object Loading : GetCompositionsNetworkState()

    class Error(val errorMessage: String) : GetCompositionsNetworkState()

    class Success(val publicCompositions: PublicCompositions) : GetCompositionsNetworkState()
}