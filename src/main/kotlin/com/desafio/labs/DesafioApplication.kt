package com.desafio.labs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class DesafioApplication

fun main(args: Array<String>) {
	runApplication<DesafioApplication>(*args)
}
