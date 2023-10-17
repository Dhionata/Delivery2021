package br.com

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan(basePackages = ["br.com.model.entities"])
@ComponentScan(basePackages = ["br.com.controllers"])
@EnableJpaRepositories(basePackages = ["br.com.repository"])
open class MainApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(MainApplication::class.java, *args)
        }
    }
}
