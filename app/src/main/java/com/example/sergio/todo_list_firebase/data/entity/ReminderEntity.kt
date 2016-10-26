package com.example.sergio.todo_list_firebase.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by BISITE on 26/10/16.
 */
@RealmClass
class ReminderEntity: RealmObject() {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    open var id: Int = 0
    @SerializedName("name")
    @Expose
    open var name: String? = null
    @SerializedName("desc")
    @Expose
    open var desc: String? = null
    @SerializedName("isNotify")
    @Expose
    open var isNotify: Boolean = false
    @SerializedName("priority")
    @Expose
    var priority: PriorityEntity? = null

}