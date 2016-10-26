package com.example.sergio.todo_list_firebase.data.mapper

import com.example.sergio.todo_list_firebase.data.entity.ReminderEntity
import com.example.sergio.todo_list_firebase.domain.models.Reminder
import java.util.*

/**
 * Created by BISITE on 26/10/16.
 */
class ReminderDataMapper(val priorityDataMapper: PriorityDataMapper): IDataMapper<Reminder, ReminderEntity> {

    override fun transform(model: ReminderEntity?): Reminder {
        if (model == null)
            throw IllegalArgumentException("Cannot transform a null value")
        val reminder = Reminder()
        reminder.name = model.name
        reminder.desc = model.desc
        reminder.isNotify = model.isNotify
        if(model.priority != null)
            reminder.priority = priorityDataMapper.transform(model.priority)
        return reminder
    }

    override fun transform(models: Collection<ReminderEntity>): Collection<Reminder> {
        val reminderCollection: Collection<Reminder>
        if (models != null && !models.isEmpty()) {
            reminderCollection = ArrayList<Reminder>()
            for (priorityEntity in models)
                reminderCollection.add(transform(priorityEntity))

        } else {
            reminderCollection = Collections.emptyList()
        }
        return reminderCollection
    }


}