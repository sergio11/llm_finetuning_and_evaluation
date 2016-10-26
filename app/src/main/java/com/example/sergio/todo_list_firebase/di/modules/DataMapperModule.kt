package com.example.sergio.todo_list_firebase.di.modules

import com.example.sergio.todo_list_firebase.data.mapper.PriorityDataMapper
import com.example.sergio.todo_list_firebase.data.mapper.ReminderDataMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by BISITE on 26/10/16.
 */
@Module
class DataMapperModule {

    @Provides
    @Singleton
    fun provideReminderDataMapper(priorityDataMapper: PriorityDataMapper): ReminderDataMapper {
        return ReminderDataMapper(priorityDataMapper)
    }

    @Provides
    @Singleton
    fun providePriorityDataMapper(): PriorityDataMapper {
        return PriorityDataMapper()
    }
}