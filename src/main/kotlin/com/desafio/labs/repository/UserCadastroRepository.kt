package com.desafio.labs.repository

import com.google.common.base.Optional
import com.desafio.labs.entities.UserCadastrado
import org.springframework.data.mongodb.repository.MongoRepository


interface UserCadastroRepository : MongoRepository<UserCadastrado, String> {
    fun findByEmail(email: String?): UserCadastrado
}