package br.com;

import javax.swing.JOptionPane;

import br.com.encrypt.Criptografia;

public class MainTestes {

    public static void main(String[] args) {
        Criptografia.argon(JOptionPane.showInputDialog("informe sua senha!"));
    }
}
