package com.viona.employee.feature.repository

import com.viona.employee.feature.entity.Employee
import com.viona.employee.feature.request.EmployeeRequest

interface EmployeeRepository {
    fun createEmployee(request: EmployeeRequest): List<Employee>

    fun findAllEmployees(): List<Employee>

    fun findEmployeeById(id: String): Employee?

    fun updateEmployee(id: String, request: EmployeeRequest): Employee?

    fun deleteEmployee(id: String)
}