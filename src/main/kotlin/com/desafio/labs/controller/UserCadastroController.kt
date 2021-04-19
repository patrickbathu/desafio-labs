package com.desafio.labs.controller

import com.desafio.labs.entities.UserCadastrado
import com.desafio.labs.repository.UserCadastroRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = arrayOf("http://localhost:4200"))
@RestController
class UserCadastroController ( val userCadastroRepository: UserCadastroRepository  ) {


    @PostMapping("v1/user/cadastro")
    fun registrate(@RequestBody user: UserCadastrado): ResponseEntity<UserCadastrado> =
         ResponseEntity.status(HttpStatus.OK).body(userCadastroRepository.save(user))

}