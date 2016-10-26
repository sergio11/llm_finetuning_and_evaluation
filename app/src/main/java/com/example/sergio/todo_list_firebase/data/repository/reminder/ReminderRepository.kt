package com.example.sergio.todo_list_firebase.data.repository.reminder

import com.example.sergio.todo_list_firebase.domain.models.Reminder
import rx.Observable

/**
 * Created by BISITE on 26/10/16.
 */
class ReminderRepository : IReminderRepository{
    override fun getReminders(): Observable<List<Reminder>> {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}