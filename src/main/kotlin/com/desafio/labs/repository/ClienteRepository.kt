package com.desafio.labs.repository

import com.desafio.labs.entities.Cliente
import com.google.common.base.Optional
import com.desafio.labs.entities.UserCadastrado
import org.springframework.data.mongodb.repository.MongoRepository


interface ClienteRepository : MongoRepository<Cliente, String> {
    fun findByEmail(email : String) : Cliente?
}