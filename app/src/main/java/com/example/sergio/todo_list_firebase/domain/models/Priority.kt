package com.example.sergio.todo_list_firebase.domain.models

/**
 * Created by sergio on 23/04/2016.
 */
class Priority {

    var id: Int = 0
    var name: String? = null
    var desc: String? = null

    constructor() {
    }

    constructor(id: Int, name: String, desc: String) {
        this.id = id
        this.name = name
        this.desc = desc
    }
}
