package com.viona.employee.repository

import com.viona.employee.entity.Employee
import com.viona.employee.request.EmployeeRequest
import org.bson.types.ObjectId

interface EmployeeRepository {
    fun createEmployee(request: EmployeeRequest): List<Employee>

    fun findAllEmployees(): List<Employee>

    fun findEmployeeById(id: ObjectId): Employee?

    fun updateEmployee(id: ObjectId, request: EmployeeRequest): Employee?

    fun deleteEmployee(id: ObjectId)
}