package com.viona.employee.repository

import com.viona.employee.entity.Employee
import com.viona.employee.request.EmployeeRequest

interface EmployeeRepository {
    fun createEmployee(request: EmployeeRequest): List<Employee>

    fun findAllEmployees(): List<Employee>

    fun findEmployeeById(id: String): Employee?

    fun updateEmployee(id: String, request: EmployeeRequest): Employee?

    fun deleteEmployee(id: String)
}