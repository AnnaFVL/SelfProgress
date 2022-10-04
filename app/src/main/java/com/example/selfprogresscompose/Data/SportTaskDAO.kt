package com.example.selfprogresscompose.Data

import androidx.room.*
import com.example.selfprogresscompose.Model.SportTask

@Dao
interface SportTaskDAO {
    @Insert
    fun addSportTask(task: SportTask?) : Int

    @Update
    fun updateSportTask(task: SportTask?)

    @Delete
    fun deleteSportTask(task: SportTask?)

    @Query ("select * from tasks")
    fun getAllSportTasks() : List<SportTask>

    @Query ("select * from tasks where type ==:sport and number ==:day")
    fun getSportTask(sport : String, day : Int) : SportTask?

}
