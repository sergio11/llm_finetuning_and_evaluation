package com.example.sergio.todo_list_firebase.data.mapper

import com.example.sergio.todo_list_firebase.data.entity.PriorityEntity
import com.example.sergio.todo_list_firebase.domain.models.Priority
import java.util.*

/**
 * Created by BISITE on 26/10/16.
 */
class PriorityDataMapper: IDataMapper<Priority, PriorityEntity>{

    override fun transform(model: PriorityEntity?): Priority {
        if(model === null)
            throw IllegalArgumentException("Cannot transform a null value")
        val priority = Priority()
        priority.id = model.id
        priority.name = model.name
        priority.desc = model.desc
        return priority
    }

    override fun transform(models: Collection<PriorityEntity>): Collection<Priority> {
        val priorityCollection: Collection<Priority>
        if (models != null && !models.isEmpty()) {
            priorityCollection = ArrayList<Priority>()
            for (priorityEntity in models)
                priorityCollection.add(transform(priorityEntity))

        } else {
            priorityCollection = Collections.emptyList()
        }
        return priorityCollection
    }
}