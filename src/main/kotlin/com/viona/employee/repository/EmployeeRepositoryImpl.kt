package com.viona.employee.repository

import com.mongodb.client.MongoCollection
import com.viona.employee.database.DatabaseComponent
import com.viona.employee.entity.Employee
import com.viona.employee.request.EmployeeRequest
import org.bson.types.ObjectId
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
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

    override fun findEmployeeById(id: ObjectId): Employee? =
        employeeCollection().findOne(Employee::id eq id)


    override fun updateEmployee(id: ObjectId, request: EmployeeRequest): Employee? {
        val employeeUpdate = findEmployeeById(id)
        val update = employeeCollection().insertOne(
            Employee(
                firstName = request.firstName,
                lastName = request.lastName,
                email = request.email
            )
        )
        return if (update.wasAcknowledged()) findEmployeeById(id)
        else throw java.lang.IllegalStateException("update gagal")
    }

    override fun deleteEmployee(id: ObjectId) {
        employeeCollection().findOneAndDelete(Employee::id eq id)
    }

}
