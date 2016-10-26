package com.example.sergio.todo_list_firebase.data.repository.reminder

import com.example.sergio.todo_list_firebase.domain.models.Reminder
import rx.Observable

/**
 * Created by BISITE on 26/10/16.
 */
interface IReminderRepository {
    fun getReminders(): Observable<List<Reminder>>
}