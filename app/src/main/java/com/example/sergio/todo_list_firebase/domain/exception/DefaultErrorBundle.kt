package com.example.sergio.todo_list_firebase.domain.exception

/**
 * Created by BISITE on 26/10/16.
 */
class DefaultErrorBundle(val exception: Exception): ErrorBundle {

    private val DEFAULT_ERROR_MSG = "Unknown error"

    override fun getErrorMessage(): String {
        return if (exception != null) exception.message.toString() else DEFAULT_ERROR_MSG
    }
}