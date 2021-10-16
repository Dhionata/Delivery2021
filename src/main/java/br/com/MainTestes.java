package br.com;

import javax.swing.JOptionPane;

import br.com.encrypt.Criptografia;
import br.com.test.model.classes.TesteCliente;

public class MainTestes {

    public static void main(String[] args) {
        while (true) {
            String senha = JOptionPane.showInputDialog("informe sua senha!");
            Criptografia.verificar(TesteCliente.novoCliente(), senha);
        }
    }
}
