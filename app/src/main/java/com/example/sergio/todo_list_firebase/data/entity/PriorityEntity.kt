package com.example.sergio.todo_list_firebase.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.annotations.PrimaryKey

/**
 * Created by BISITE on 26/10/16.
 */
class PriorityEntity {

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

}