package br.edu.satc.todolistcompose

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update

//data class TaskData (
//    val title: String,
//    val description: String,
//    val complete: Boolean
//)

@Entity
data class TaskData(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "complete") val complete: Boolean
)

@Dao
interface TaskDao {
    @Query("SELECT * FROM taskdata")
    fun getAll(): List<TaskData>

    @Update
    fun updateData(vararg taskData: TaskData)

    @Insert
    fun insertAll(vararg taskData: TaskData)
}