package cl.duoc.im_deaf_app.core.database

//import cl.duoc.im_deaf_app.model.AlertModel
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.ValueEventListener
//import kotlinx.coroutines.channels.awaitClose
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.callbackFlow

//class RealtimeManager() {
//    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference.child("data")
//
//
//    // as of now, for time, we just consult the database
//    fun getAlarms() : Flow<List<AlertModel>> {
//        val flow = callbackFlow {
//            val listener = databaseReference.addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    val alarms = snapshot.children.mapNotNull { snapshot ->
//                        val alarm = snapshot.getValue(AlertModel::class.java)
//                        snapshot.key?.let { alarm?.copy(it) }
//                    }
//                    trySend(alarms).isSuccess
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    close(error.toException())
//                }
//
//            })
//
//            awaitClose { databaseReference.removeEventListener(listener)}
//        }
//        return flow
//    }
//}
