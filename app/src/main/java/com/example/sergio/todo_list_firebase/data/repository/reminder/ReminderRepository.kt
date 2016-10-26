package com.example.sergio.todo_list_firebase.data.repository.reminder

import com.example.sergio.todo_list_firebase.data.mapper.ReminderDataMapper
import com.example.sergio.todo_list_firebase.domain.models.Reminder
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by BISITE on 26/10/16.
 */
@Singleton
class ReminderRepository @Inject constructor(val localDataStore: LocalReminderDataStore, val reminderDataMapper: ReminderDataMapper): IReminderRepository{
    override fun getReminders(): Observable<Reminder> {
        return localDataStore.getReminders().map { reminder ->  reminderDataMapper.transform(reminder) }
    }
}