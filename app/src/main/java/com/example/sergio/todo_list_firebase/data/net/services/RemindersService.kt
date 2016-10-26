package com.example.sergio.todo_list_firebase.data.net.services

import com.example.sergio.todo_list_firebase.data.entity.ReminderEntity
import retrofit.Result
import retrofit.http.GET
import rx.Observable

/**
 * Created by BISITE on 26/10/16.
 */
interface RemindersService {
    @GET("reminders/all")
    fun getReminders(): Observable<Result<ReminderEntity>>
}