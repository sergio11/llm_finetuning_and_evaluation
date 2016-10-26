package com.example.sergio.todo_list_firebase.data.bd.transformers

import io.realm.RealmObject
import io.realm.RealmResults
import rx.Observable

/**
 * Created by BISITE on 26/10/16.
 */
class NullIfNoRealmObject<RlmObject: RealmObject>: Observable.Transformer<RealmResults<RlmObject>, RlmObject> {
    override fun call(observable: Observable<RealmResults<RlmObject>>): Observable<RlmObject> {
        return observable.filter{rs -> rs != null && rs.isLoaded}.map{rs ->
            if (rs.size > 0) {
                rs.first()
            }
            null
        }
    }
}