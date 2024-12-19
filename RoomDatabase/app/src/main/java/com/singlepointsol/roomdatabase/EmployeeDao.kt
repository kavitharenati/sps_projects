package com.singlepointsol.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmployeeDao {
    @Insert
    fun addEmployee(employee: Employee)

    @Query
    fun getAllEmployees()
}