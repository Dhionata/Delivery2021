package br.com.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @RequestMapping(value = ["/hello"], method = [RequestMethod.GET])
    private fun hello(@RequestParam(value = "name", defaultValue = "World") name: String): String {
        return String.format("Hello %s!", name)
    }
}
