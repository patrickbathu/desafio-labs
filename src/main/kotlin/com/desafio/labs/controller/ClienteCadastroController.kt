package com.desafio.labs.controller


import com.desafio.labs.entities.Cliente
import com.desafio.labs.repository.ClienteRepository
import com.desafio.labs.service.ClienteService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.ws.rs.PUT

@RestController
class ClienteCadastroController(val clienteService: ClienteService, val clienteRepository : ClienteRepository) {

    @PostMapping("v1/cliente",  produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody cliente: Cliente): ResponseEntity<Cliente> =
        ResponseEntity.status(HttpStatus.CREATED).body(clienteService.saveCliente(cliente))

    @PutMapping("v1/cliente", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody cliente: Cliente): ResponseEntity<Cliente> =
        ResponseEntity.status(HttpStatus.OK).body(clienteService.update(cliente))

    @GetMapping("v1/cliente/{email}/email" , produces = [MediaType.APPLICATION_JSON_VALUE])
    fun clienteFindByEmail(@PathVariable email: String): ResponseEntity<Cliente> =
        ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findByEmail(email))

    @GetMapping("v1/cliente/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun clienteFindById(@PathVariable id: String): ResponseEntity<Cliente> =
        ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findById(id).get())
}