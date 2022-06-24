package com.viona.employee.entity

import java.util.*

data class Employee(
    val id: String = UUID.randomUUID().toString(),
    var firstName: String,
    var lastName: String,
    var email: String
    //var company: Company?
)