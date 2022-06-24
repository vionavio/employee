package com.viona.employee.response

import com.viona.employee.entity.Company

class CompanyResponse(
    val id: String,
    val name: String,
    val address: String
) {
    companion object {
        fun fromEntity(company: Company): CompanyResponse =
            CompanyResponse(
                id = company.id!!,
                name = company.name,
                address = company.address
            )
    }
}