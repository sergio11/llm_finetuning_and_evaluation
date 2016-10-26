package com.example.sergio.todo_list_firebase.di.modules

import com.example.sergio.todo_list_firebase.data.repository.reminder.ReminderRepository
import com.example.sergio.todo_list_firebase.domain.executor.IPostExecutionThread
import com.example.sergio.todo_list_firebase.domain.executor.IThreadExecutor
import com.example.sergio.todo_list_firebase.domain.interact.GetAllRemindersInteracts
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by BISITE on 26/10/16.
 */
@Module
class InteractsModule {

    @Provides
    @Singleton
    fun provideGetAllRemindersInteract(reminderRepository: ReminderRepository, threadExecutor: IThreadExecutor, postExecutionThread: IPostExecutionThread): GetAllRemindersInteracts{
        return GetAllRemindersInteracts(reminderRepository,threadExecutor, postExecutionThread)
    }

}