package com.desafio.labs.service

import com.desafio.labs.clients.ProdutosClient
import com.desafio.labs.entities.Cliente
import com.desafio.labs.entities.Produto
import com.desafio.labs.repository.ClienteRepository
import org.springframework.stereotype.Service

@Service
class ClienteService ( val clienteRepository: ClienteRepository, val produtosClient : ProdutosClient ){

    fun saveCliente(cliente: Cliente) : Cliente {

        if (validaEmail(cliente) && validarProduto(cliente?.favoritos)
            && validaQuantidadeFavoritos(cliente?.favoritos)){

            return clienteRepository.save(cliente)
        }else {
            throw IllegalArgumentException("")
        }
    }

    fun update(cliente: Cliente) : Cliente{
        if (validarProduto(cliente?.favoritos) && validaQuantidadeFavoritos(cliente?.favoritos)){
            return clienteRepository.save(cliente)
        }else {
            throw IllegalArgumentException("")
        }
    }

    private fun validaEmail(cliente: Cliente) : Boolean =
        clienteRepository.findByEmail(cliente?.email) == null

    private fun validarProduto(favoritos : Set<Produto>?) : Boolean {
        favoritos?.forEach { produto ->
            if (produtosClient.getProductById(produto?.id) == null){
                return false
            }
        }
        return true
    }

    private fun validaQuantidadeFavoritos(produtos : Set<Produto>?) : Boolean =
        produtos?.size in 0..10

}
