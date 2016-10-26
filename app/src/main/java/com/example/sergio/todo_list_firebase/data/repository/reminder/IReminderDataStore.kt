package com.example.sergio.todo_list_firebase.data.repository.reminder

import com.example.sergio.todo_list_firebase.data.entity.ReminderEntity
import rx.Observable

/**
 * Created by BISITE on 26/10/16.
 */
interface IReminderDataStore {
    fun getReminders(): Observable<ReminderEntity>
}