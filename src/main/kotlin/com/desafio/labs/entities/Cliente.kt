package com.desafio.labs.entities

import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.UniqueConstraint

@Document
data class Cliente(
    @Id @GeneratedValue
    val _id : String? = null,
    val nome : String,
    val email : String,
    val favoritos : Set<Produto>? = null
)
