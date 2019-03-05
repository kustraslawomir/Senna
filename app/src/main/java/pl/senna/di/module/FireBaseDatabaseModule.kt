package pl.senna.di.module

import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import pl.senna.di.scopes.AppScope

@Module
class FireBaseDatabaseModule {

  @Provides
  @AppScope
  fun fireBaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()
}