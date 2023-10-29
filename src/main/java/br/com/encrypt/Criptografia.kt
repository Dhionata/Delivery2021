package br.com.encrypt

import br.com.model.usuario.Usuario
import de.mkammerer.argon2.Argon2Factory
import de.mkammerer.argon2.Argon2Helper
import kotlin.time.measureTime

object Criptografia {
    private var argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id)
    private var parallelism = Runtime.getRuntime().availableProcessors()
    private const val MEMORYFREE = 65536
    private val iterations = Argon2Helper.findIterations(argon2, 500, MEMORYFREE, parallelism).also {
        println("Optimal number of iterations: $it")
    }

    @JvmStatic
    fun argon(senha: String): String {
        return run {
            println("\nSenha: \n$senha\n")
            val hash: String
            println("Demorou: ${
                measureTime {
                    hash = argon2.hash(iterations, MEMORYFREE, parallelism, senha.toCharArray())
                }
            } para gerar o Hash.\nHash:\n$hash")
            hash
        }
    }

    @JvmStatic
    fun verificar(usuario: Usuario, senha: String): Boolean {
        println("\nHash do usuario:${usuario.senha}\nSenha a ser verificada:$senha")
        return if (argon2.verify(usuario.senha, senha.toCharArray())) {
            println("Tudo blz!")
            true
        } else {
            println("Deu ruim!\nA verificação dos Hash não batem… =/")
            false
        }
    }
}
