package br.com.encrypt

import br.com.model.entities.classes.usuario.Usuario
import de.mkammerer.argon2.Argon2Factory
import de.mkammerer.argon2.Argon2Helper
import javax.swing.JOptionPane
import kotlin.time.measureTime

object Criptografia {
    var argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id)
    var parallelism = Runtime.getRuntime().availableProcessors()
    var memoryFree = 65536
    val iterations = Argon2Helper.findIterations(argon2, 500, memoryFree, parallelism)

    @JvmStatic
    fun argon(senha: String): String? {
        return try {
            println("\nSenha: \n$senha\n")
            val hash: String
            println("Demorou: ${
                measureTime {
                    println("\nOptimal number of iterations: $iterations")
                    hash = argon2.hash(iterations, memoryFree, parallelism, senha.toCharArray())
                    println(hash)
                }
            } para gerar o Hash.")
            hash
        } catch (e: Exception) {
            JOptionPane.showMessageDialog(null, e.message, "Error", JOptionPane.ERROR_MESSAGE)
            e.message
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
