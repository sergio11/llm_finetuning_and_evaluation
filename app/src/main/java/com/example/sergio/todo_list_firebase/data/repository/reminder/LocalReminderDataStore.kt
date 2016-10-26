package com.example.sergio.todo_list_firebase.data.repository.reminder

import com.example.sergio.todo_list_firebase.data.bd.transformers.NullIfNoRealmObject
import com.example.sergio.todo_list_firebase.data.entity.ReminderEntity
import io.realm.Realm
import rx.Observable
import rx.subscriptions.Subscriptions
import javax.inject.Singleton

/**
 * Created by BISITE on 26/10/16.
 */
@Singleton
class LocalReminderDataStore: IReminderDataStore{

    override fun getReminders(): Observable<ReminderEntity> {
        return Observable.defer {
            getManagedRealm().concatMap {
                realm -> realm.where(ReminderEntity::class.java)
                    .findAllAsync()
                    .asObservable()
                    .compose(NullIfNoRealmObject<ReminderEntity>())
            }
        }
    }

    private fun getManagedRealm(): Observable<Realm> {
        return Observable.create { subscriber ->
            val realm = Realm.getDefaultInstance()
            subscriber.add(Subscriptions.create{ realm.close() })
            subscriber.onNext(realm)
        }
    }
}