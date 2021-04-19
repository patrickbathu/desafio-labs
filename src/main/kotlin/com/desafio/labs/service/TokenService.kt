package com.desafio.labs.service


import com.desafio.labs.model.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Service
import java.util.*


@Service
class TokenService {
    private val key =
        Keys.hmacShaKeyFor("7f-j&CKk=coNzZc0y7_4obMP?#TfcYq%fcD0mDpenW2nc!lfGoZ|d?f&RNbDHUX6"
            .getBytes(StandardCharsets.UTF_8));

    //30 minutos
    private val expirationTime: Long = 1800000

    fun generateToken(user: User?): String? {
        return Jwts.builder()
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setSubject("Teste JWT API")
            .setExpiration(Date(System.currentTimeMillis() + expirationTime))
            .signWith(SignatureAlgorithm.HS256, key)
            .compact()
    }

    fun decodeToken(token: String?): Claims? {
        return Jwts.parser()
            .setSigningKey(key)
            .parseClaimsJws(token)
            .body
    }
}