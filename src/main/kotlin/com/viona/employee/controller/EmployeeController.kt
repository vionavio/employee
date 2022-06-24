package com.viona.employee.controller

import com.viona.employee.entity.Employee
import com.viona.employee.request.EmployeeRequest
import com.viona.employee.response.BaseResponse
import com.viona.employee.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1/employee")
class EmployeeController {

    @Autowired
    private lateinit var employeeService: EmployeeService

    @PostMapping
    fun createEmployee(@RequestBody request: EmployeeRequest): BaseResponse<List<Employee>> {
        val createdEmployee = employeeService.createEmployee(request)

        return BaseResponse(
            status = true,
            message = "Success",
            data = createdEmployee
        )
    }

    @GetMapping
    fun findAllEmployees(): BaseResponse<List<Employee>> {
        val employees = employeeService.findAllEmployees()

        return BaseResponse(
            status = true,
            message = "Success",
            data = employees
        )
    }

    @GetMapping("/{id}")
    fun findEmployeeById(@PathVariable id: String): BaseResponse<Employee?> {
        val employee = employeeService.findEmployeeById(id)

        return BaseResponse(
            status = true,
            message = "Success",
            data = employee
        )
    }

//    @GetMapping("/company/{companyId}")
//    fun findAllByCompanyId(@PathVariable companyId: String): ResponseEntity<List<EmployeeResponse>> {
//        val employees = employeeService.findAllByCompanyId(companyId)
//
//        return ResponseEntity
//            .ok(
//                employees.map { EmployeeResponse.fromEntity(it) }
//            )
//    }

    @PutMapping("/{id}")
    fun updateUpdateEmployee(
        @PathVariable id: String,
        @RequestBody request: EmployeeRequest
    ): BaseResponse<Employee?> {
        val updatedEmployee = employeeService.updateEmployee(id, request)
        return BaseResponse(
            status = true,
            message = "Success",
            data = updatedEmployee
        )
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: String): ResponseEntity<Void> {
        employeeService.deleteEmployee(id)

        return ResponseEntity.noContent().build()
    }
}