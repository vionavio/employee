package com.viona.employee.response

data class BaseResponse<T>(
    var status: Boolean = false,
    var message: String = "",
    var data: T
)