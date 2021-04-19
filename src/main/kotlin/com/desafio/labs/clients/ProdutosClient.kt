package com.desafio.labs.clients

import com.desafio.labs.entities.Produto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "get-produtos", url = "http://challenge-api.luizalabs.com/api")
interface ProdutosClient {

    @GetMapping(path = ["/product/?page={page}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getProductsByPages(@PathVariable("page") page: Integer): List<Produto>

    @GetMapping(path = ["/product/{id}/"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getProductById(@PathVariable("id") id: String?): Produto

}