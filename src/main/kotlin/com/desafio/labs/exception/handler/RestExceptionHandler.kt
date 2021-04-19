package com.desafio.labs.exception.handler;

import com.desafio.labs.exception.ExceptionResponse
import com.desafio.labs.exception.ExistingEmailException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler(){

        @ExceptionHandler(ExistingEmailException::class)
        fun handleOrderNotFoundExpecption(ex: ExistingEmailException, request: WebRequest): ResponseEntity<Any> {
                val exceptionResponse = ExceptionResponse("ORDER_NOT_FOUND", ex.mensagem)
                request.getDescription(false)
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exceptionResponse)
        }
}
