package com.example.utils;

public class Verificador {

    public static boolean isOpcaoValida(String opcao) {
        return opcao.equals("1") || opcao.equals("2") || opcao.equals("3") || opcao.equals("4") || opcao.equals("5");
    }

    public static boolean isOpcaoCadastro(String opcao) {
        return opcao.equals("1");
    }

    public static boolean isOpcaoConsulta(String opcao) {
        return opcao.equals("2");
    }

    public static boolean isOpcaoExclusao(String opcao) {
        return opcao.equals("3");
    }

    public static boolean isOpcaoAtualizar(String opcao) {
        return opcao.equals("4");
    }

    public static boolean isOpcaoSair(String opcao) {
        return opcao.equals("5");
    }

}
