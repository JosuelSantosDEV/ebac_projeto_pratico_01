package com.example;

import com.example.dao.ClienteMapDAO;
import com.example.dao.IClienteDAO;

import javax.swing.*;

public class Main {

    private static IClienteDAO clienteDAO;

    public static void main(String[] args) {

        clienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração, 5 para sair",
                    "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE
                );
        while(!isOpcaoValida(opcao)){
            if(opcao.isEmpty() || opcao.isBlank()) sair();
            opcao = JOptionPane.showInputDialog(null,
                    "Opção Invalida!!! Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração, 5 para sair",
                    "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo", "Saindo!!!", JOptionPane.WARNING_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        return opcao.equals("1") || opcao.equals("2") || opcao.equals("3") || opcao.equals("4") || opcao.equals("5");
    }

    private static boolean isOpcaoCadastro(String opcao) {
        return opcao.equals("1");
    }
}