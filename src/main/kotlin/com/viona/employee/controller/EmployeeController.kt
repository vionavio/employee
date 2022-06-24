package com.viona.employee.controller

import com.viona.employee.request.EmployeeRequest
import com.viona.employee.response.EmployeeResponse
import com.viona.employee.service.EmployeeService
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/employee")
class EmployeeController{

    @Autowired
    private lateinit var employeeService: EmployeeService

//    @PostMapping
//    fun createEmployee(@RequestBody request: EmployeeRequest): ResponseEntity<List<EmployeeResponse>> {
//        val createdEmployee = employeeService.createEmployee(request)
//
//        return ResponseEntity.ok(
//                EmployeeResponse(
//
//                )
//            )
//    }

    @GetMapping
    fun findAllEmployees(): ResponseEntity<List<EmployeeResponse>> {
        val employees = employeeService.findAllEmployees()

        return ResponseEntity
            .ok(
                employees.map { EmployeeResponse.fromEntity(it) }
            )
    }

    @GetMapping("/{id}")
    fun findEmployeeById(@PathVariable id: ObjectId): ResponseEntity<EmployeeResponse> {
        val employee = employeeService.findEmployeeById(id)

        return ResponseEntity
            .ok(
                EmployeeResponse.fromEntity(employee)
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

//    @PutMapping("/{id}")
//    fun updateUpdateEmployee(
//        @PathVariable id: ObjectId,
//        @RequestBody request: EmployeeRequest
//    ): ResponseEntity<EmployeeResponse> {
//        val updatedEmployee = employeeService.updateEmployee(id, request)
//
//        return ResponseEntity
//            .ok(
//                EmployeeResponse.fromEntity(updatedEmployee)
//            )
//    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: ObjectId): ResponseEntity<Void> {
        employeeService.deleteEmployee(id)

        return ResponseEntity.noContent().build()
    }
}