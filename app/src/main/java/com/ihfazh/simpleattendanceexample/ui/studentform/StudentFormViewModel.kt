package com.ihfazh.simpleattendanceexample.ui.studentform

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.fragment.findNavController
import com.ihfazh.simpleattendanceexample.datasource.local.AppDatabase
import com.ihfazh.simpleattendanceexample.datasource.local.models.StudentEntity
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class StudentFormViewModel(application: Application): AndroidViewModel(application) {
    private val db = AppDatabase.getInstance(application)
    fun addStudent(firstName: String, lastName: String): Completable{
        val id = UUID.randomUUID().toString()
        return db.studentDao()
            .insert(
                StudentEntity(
                    id,
                    firstName,
                    lastName
                )
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}