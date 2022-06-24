package com.viona.employee.service

import com.viona.employee.entity.Employee
import com.viona.employee.repository.EmployeeRepository
import com.viona.employee.request.EmployeeRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl : EmployeeService {

    @Autowired
    private lateinit var employeeRepository: EmployeeRepository

    override fun createEmployee(request: EmployeeRequest): List<Employee> =
        employeeRepository.createEmployee(request)

    override fun findAllEmployees(): List<Employee> =
        employeeRepository.findAllEmployees()

    override fun findEmployeeById(id: String): Employee? =
        employeeRepository.findEmployeeById(id)

//    override fun findAllByCompanyId(companyId: String): List<Employee> {
//        TODO("Not yet implemented")
//    }

    override fun updateUpdateEmployee(id: String, request: EmployeeRequest): Employee? =
        employeeRepository.updateEmployee(id, request)

    override fun deleteEmployee(id: String) {
        employeeRepository.deleteEmployee(id)
    }
}