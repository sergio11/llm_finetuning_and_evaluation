package com.example.sergio.todo_list_firebase.domain.models


/**
 * Created by sergio on 23/04/2016.
 */
class Reminder {

    var id: Int = 0
    var name: String? = null
    var desc: String? = null
    var isNotify: Boolean = false
    var priority: Priority? = null

    constructor() {
    }

    constructor(name: String, id: Int, notify: Boolean, priority: Priority, desc: String) {
        this.name = name
        this.id = id
        this.isNotify = notify
        this.priority = priority
        this.desc = desc
    }
}
