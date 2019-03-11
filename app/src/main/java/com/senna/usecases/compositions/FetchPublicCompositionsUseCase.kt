package com.senna.usecases.compositions

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.senna.model.fetchstates.GetCompositionsNetworkState
import com.senna.model.firebase.PublicCompositions
import javax.inject.Inject

class FetchPublicCompositionsUseCase @Inject constructor(private val fireBaseDatabaseModule: FirebaseDatabase) {

    fun fetchPublicCompositions(onFetchingStatusChange: (GetCompositionsNetworkState) -> Unit) {
        onFetchingStatusChange(GetCompositionsNetworkState.Loading)

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val publicCompositions = dataSnapshot.getValue(PublicCompositions::class.java)
                if (publicCompositions != null)
                    onFetchingStatusChange(GetCompositionsNetworkState.Response(publicCompositions))
            }

            override fun onCancelled(databaseError: DatabaseError) {
                onFetchingStatusChange(GetCompositionsNetworkState.Error(databaseError.message))
            }
        }
        fireBaseDatabaseModule.reference.addListenerForSingleValueEvent(postListener)
    }
}