package com.ihfazh.simpleattendanceexample.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ihfazh.simpleattendanceexample.datasource.local.dao.StudentDao
import com.ihfazh.simpleattendanceexample.datasource.local.models.StudentEntity

@Database(
    entities = [StudentEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null){
                synchronized(AppDatabase::class){
                    if (instance == null){
                        instance = Room.databaseBuilder(
                            context,
                            AppDatabase::class.java,
                            "simple-attendance-app"
                        ).build()
                    }
                }
            }
            return instance!!
        }
    }

    abstract fun studentDao(): StudentDao
}