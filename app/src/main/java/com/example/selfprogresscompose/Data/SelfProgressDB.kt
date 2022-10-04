package com.example.selfprogresscompose.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.selfprogresscompose.Model.SportTask

@Database(entities = [SportTask::class], version = 1)
abstract class SelfProgressDB: RoomDatabase() {
    abstract val sportDAO : SportTaskDAO?
}
