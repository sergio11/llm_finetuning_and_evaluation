package com.example.sergio.todo_list_firebase.data.mapper

/**
 * Created by BISITE on 26/10/16.
 */
interface IDataMapper<T, E> {
    fun transform(model: E?): T
    fun transform(models: Collection<E>): Collection<T>
}