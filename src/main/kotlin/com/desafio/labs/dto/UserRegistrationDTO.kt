package com.desafio.labs.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.desafio.labs.model.User

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
data class UserRegistrationDTO(
    var id : Long,
    val nome : String,
    val email: String,
    val senha : String,
)



