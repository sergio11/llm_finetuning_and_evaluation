package com.example.sergio.todo_list_firebase.domain.executor

import rx.Scheduler

/**
 * Created by BISITE on 26/10/16.
 */
interface IPostExecutionThread {
    fun getScheduler(): Scheduler
}