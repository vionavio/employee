package com.viona.employee.feature.service

import com.viona.employee.feature.entity.Employee
import com.viona.employee.feature.repository.EmployeeRepository
import com.viona.employee.feature.request.EmployeeRequest
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

    override fun updateEmployee(id: String, request: EmployeeRequest): Employee? =
        employeeRepository.updateEmployee(id, request)

    override fun deleteEmployee(id: String) {
        employeeRepository.deleteEmployee(id)
    }
}