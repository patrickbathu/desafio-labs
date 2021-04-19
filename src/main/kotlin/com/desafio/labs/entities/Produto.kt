package com.desafio.labs.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Produto(
    var id : String,
    var price : Double? = null,
    var image : String? = null,
    var title : String? = null
)
