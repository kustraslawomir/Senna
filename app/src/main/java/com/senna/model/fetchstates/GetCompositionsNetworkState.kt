package com.senna.model.fetchstates

import com.senna.model.firebase.PublicCompositions

sealed class GetCompositionsNetworkState {

    object Loading : GetCompositionsNetworkState()

    data class Error(val errorMessage : String) : GetCompositionsNetworkState()

    data class Response(val publicCompositions : PublicCompositions) : GetCompositionsNetworkState()
}