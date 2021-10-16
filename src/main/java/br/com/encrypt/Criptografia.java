package br.com.encrypt;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;

import br.com.model.entities.classes.Usuario.Cliente;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Helper;

public class Criptografia {

    private static Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id, 16, 32);

    public static String argon(String senha) {
        try {
            String hash;
            var start = Instant.now();

            var iterations = Argon2Helper.findIterations(argon2, 1000, 65536, 1);

            System.out.println("\nOptimal number of iterations: " + iterations);

            hash = argon2.hash(iterations, 65536, 1, senha.toCharArray());

            System.out.println("\n" + hash);

            var end = Instant.now();
            System.out.println("Hashing took\n" + ChronoUnit.MILLIS.between(start, end) + "ms.");

            return hash;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return e.getMessage();
        }
    }

    public static boolean verificar(Cliente cliente, String senha) {
        System.out.println("\nSenha do cliente: " + cliente.getSenha() + "\nSenha a ser verificada: " + senha);
        if (argon2.verify(cliente.getSenha(), senha.toCharArray())) {
            System.out.println("Tudo blz!");
            return true;
        } else {
            System.out.println("Deu ruim!\nA verificação dos Hash não batem.. =/");
            return false;
        }
    }
}