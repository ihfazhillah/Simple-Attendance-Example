package com.ihfazh.simpleattendanceexample.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ihfazh.simpleattendanceexample.datasource.local.models.StudentEntity
import io.reactivex.Completable

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: StudentEntity): Completable
}