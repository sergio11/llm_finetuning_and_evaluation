package com.example.sergio.todo_list_firebase

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by BISITE on 26/10/16.
 */

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val realmConfig = RealmConfiguration.Builder(this).deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(realmConfig)
    }
}