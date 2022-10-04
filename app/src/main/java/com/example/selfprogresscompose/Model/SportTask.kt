package com.example.selfprogresscompose.Model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "tasks")
data class SportTask (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "type")
    val sportActivity: String,
    @ColumnInfo(name = "number")
    val dayOfWeek: Int,
    @ColumnInfo(name = "value")
    var checked: Boolean,

    @Ignore
    val weight: Double
)