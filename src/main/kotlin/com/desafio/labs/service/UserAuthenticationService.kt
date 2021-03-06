package com.desafio.labs.service

import com.desafio.labs.dto.DadosLogin
import com.desafio.labs.exception.ExpiredTokenException
import com.desafio.labs.exception.InvalidLoginException
import com.desafio.labs.exception.InvalidTokenException
import com.desafio.labs.model.User
import com.desafio.labs.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class UserAuthenticationService {

    private var userRepository: UserRepository? = null
    private var tokenService: TokenService? = null

    @Autowired
    fun UserAuthenticationService(userRepository: UserRepository?, tokenService: TokenService?) {
        this.userRepository = userRepository
        this.tokenService = tokenService
    }

    fun authenticate(dados: DadosLogin?, token: String?): User? {
        println("UserAuthenticationService.authenticate -  dados [ $dados ]  token [ $token ] ")
        val user: User? = userRepository?.findByEmail(dados?.email)
        println("UserAuthenticationService.authenticate -  user [ $user ]")
        if (token != null) {
            return if (dados?.senha == user?.senha && token == user?.token && validate(token)) {
                user
            } else {
                throw InvalidLoginException()
            }
        }else {
            throw InvalidLoginException()
        }
    }

    fun logout(dados: DadosLogin?){
        println("UserAuthenticationService.logout -  dados [ ${dados?.email} ]")
        val user: User? = userRepository?.deleteByEmail(dados?.email)
        println("UserAuthenticationService.logout -  user [ $user ]")
    }

    private fun validate(token: String?): Boolean {
        return try {
            val tokenTratado = token?.replace("Bearer ", "")
            val claims = tokenService!!.decodeToken(tokenTratado)
            println("UserAuthenticationService.validate - CreateToken " + claims!!.issuer)
            println("UserAuthenticationService.validate - CreateToken " + claims.issuedAt)
            //Verifica se o token est?? expirado
            if (claims.expiration.before(Date(System.currentTimeMillis()))) throw ExpiredTokenException()
            println("UserAuthenticationService.validate - ExpirationToken " + claims.expiration)
            true
        } catch (et: ExpiredTokenException) {
            et.printStackTrace()
            throw et
        } catch (e: Exception) {
            e.printStackTrace()
            throw InvalidTokenException()
        }
    }
}