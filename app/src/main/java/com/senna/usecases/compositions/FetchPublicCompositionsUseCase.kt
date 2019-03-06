package com.senna.usecases.compositions

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.senna.model.firebase.PublicCompositions
import timber.log.Timber
import javax.inject.Inject

class FetchPublicCompositionsUseCase @Inject constructor(private val fireBaseDatabaseModule: FirebaseDatabase) {

    fun fetchPublicCompositions(onFetchPublicCompositionsEnd: (PublicCompositions) -> Unit) {
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val publicCompositions = dataSnapshot.getValue(PublicCompositions::class.java)
                if (publicCompositions != null) {
                    onFetchPublicCompositionsEnd(publicCompositions)
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Timber.e("loadPost:onCancelled %s", databaseError.message)
            }
        }
        fireBaseDatabaseModule.reference.addListenerForSingleValueEvent(postListener)
    }
}