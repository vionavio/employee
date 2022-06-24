package com.viona.employee.service

import com.viona.employee.entity.Employee
import com.viona.employee.request.EmployeeRequest

interface EmployeeService {

    fun createEmployee(request: EmployeeRequest): List<Employee>

    fun findAllEmployees(): List<Employee>

    fun findEmployeeById(id: String): Employee?

   // fun findAllByCompanyId(companyId: String): List<Employee>

    fun updateUpdateEmployee(id: String, request: EmployeeRequest): Employee?

    fun deleteEmployee(id: String)
}