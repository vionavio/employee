package com.viona.employee.service

import com.viona.employee.entity.Employee
import com.viona.employee.request.EmployeeRequest
import org.bson.types.ObjectId

interface EmployeeService {

    fun createEmployee(request: EmployeeRequest): List<Employee>

    fun findAllEmployees(): List<Employee>

    fun findEmployeeById(id: ObjectId): Employee?

   // fun findAllByCompanyId(companyId: String): List<Employee>

    fun updateUpdateEmployee(id: ObjectId, request: EmployeeRequest): Employee?

    fun deleteEmployee(id: ObjectId)
}