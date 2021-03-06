package com.desafio.labs.controller

import com.desafio.labs.dto.UserAutheticatedDTO
import com.desafio.labs.dto.UserRegistrationDTO
import com.desafio.labs.model.User
import com.desafio.labs.service.UserRegistrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = arrayOf("http://localhost:4200"))
@RestController
class UserRegistrationController {

    private var userRegistrationService: UserRegistrationService? = null

    private var userAutheticatedDTO: UserAutheticatedDTO? = null

    @Autowired
    fun UserRegistrationController(userRegistrationService: UserRegistrationService?) {
        this.userRegistrationService = userRegistrationService
    }

    @PostMapping("v1/user")
    fun registrate(@RequestBody user: User): ResponseEntity<User> =
         ResponseEntity.status(HttpStatus.OK).body(userRegistrationService?.registrate(user))

}