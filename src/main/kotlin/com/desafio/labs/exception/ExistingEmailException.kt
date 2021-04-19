package com.desafio.labs.exception

import java.lang.RuntimeException

class ExistingEmailException(val mensagem :String) : RuntimeException(){
}