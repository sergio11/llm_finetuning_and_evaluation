package com.example.sergio.todo_list_firebase.data.entity

/**
 * Created by BISITE on 26/10/16.
 */
class ReminderEntity {

    var id: Int = 0
    var name: String? = null
    var desc: String? = null
    var isNotify: Boolean = false
    var priority: PriorityEntity? = null

}