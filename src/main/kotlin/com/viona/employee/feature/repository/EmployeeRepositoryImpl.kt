package com.viona.employee.feature.repository

import com.mongodb.client.MongoCollection
import com.viona.employee.database.DatabaseComponent
import com.viona.employee.feature.entity.Employee
import com.viona.employee.feature.request.EmployeeRequest
import org.litote.kmongo.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class EmployeeRepositoryImpl : EmployeeRepository {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun employeeCollection(): MongoCollection<Employee> =
        databaseComponent.database.getDatabase("employee").getCollection()

    override fun createEmployee(request: EmployeeRequest): List<Employee> {
        val insert = employeeCollection().insertOne(
            Employee(
                firstName = request.firstName,
                lastName = request.lastName,
                email = request.email
            )
        )

        return if (insert.wasAcknowledged()) findAllEmployees()
        else throw java.lang.IllegalStateException("insert gagal")
    }

    override fun findAllEmployees(): List<Employee> =
        employeeCollection().find().toList()

    override fun findEmployeeById(id: String): Employee? =
        employeeCollection().findOne(Employee::id eq id)


    override fun updateEmployee(id: String, request: EmployeeRequest): Employee? {
        val update = employeeCollection().updateOne(
            Employee::id eq id,
            Employee(
                firstName = request.firstName,
                lastName = request.lastName,
                email = request.email
            )
        )
        return if (update.wasAcknowledged()) findEmployeeById(id)
        else throw java.lang.IllegalStateException("update gagal")
    }

    override fun deleteEmployee(id: String) {
        employeeCollection().findOneAndDelete(Employee::id eq id)
    }

}
