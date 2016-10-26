package com.example.sergio.todo_list_firebase.domain.interact

import com.example.sergio.todo_list_firebase.data.repository.reminder.ReminderRepository
import com.example.sergio.todo_list_firebase.domain.executor.IPostExecutionThread
import com.example.sergio.todo_list_firebase.domain.executor.IThreadExecutor
import com.example.sergio.todo_list_firebase.domain.models.Reminder
import rx.Observable

/**
 * Created by BISITE on 26/10/16.
 */
class GetAllRemindersInteracts(
        val reminderRepository: ReminderRepository,
        threadExecutor: IThreadExecutor,
        postExecutionThread: IPostExecutionThread
) : BaseInteract<Reminder, String>(threadExecutor, postExecutionThread) {
    override fun buildUseCaseObservable(param: String): Observable<Reminder> {
        return reminderRepository.getReminders()
    }
}