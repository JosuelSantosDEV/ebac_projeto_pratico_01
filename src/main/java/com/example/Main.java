package com.example;

import com.example.dao.ClienteMapDAO;
import com.example.dao.ClienteSetDAO;
import com.example.dao.IClienteDAO;
import com.example.domain.Cliente;
import com.example.utils.Verificador;

import static com.example.utils.Verificador.*;

import javax.swing.*;

public class Main {

    private static IClienteDAO clienteDAO;

    public static void main(String[] args) {

        clienteDAO = new ClienteSetDAO();

        String opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração, 5 para sair",
                    "Menu",
                    JOptionPane.INFORMATION_MESSAGE
                );
        while(!isOpcaoValida(opcao)){
            if(isOpcaoSair(opcao)) sair();
            opcao = JOptionPane.showInputDialog(null,
                    "Opção Invalida!!! Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração, 5 para sair",
                    "Menu",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        while(isOpcaoValida(opcao)){
            if(isOpcaoSair(opcao)) sair();
            else if (isOpcaoCadastro(opcao)){
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula," +
                                " exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado",
                        "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE
                );
                cadastrar(dados);
            } else if (isOpcaoConsulta(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Informe o CPF para a consulta",
                        "Consultar",
                        JOptionPane.INFORMATION_MESSAGE
                );
                consultar(dados);
            } else if (isOpcaoExclusao(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Informe o CPF para a exclusão",
                        "Excluir",
                        JOptionPane.INFORMATION_MESSAGE
                );
                excluir(dados);
            } else if (isOpcaoAtualizar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Informe os dados separados por vírgula, exemplo:  Nome, CPF, Telefone, Endereço, Número, Cidade, Estado",
                        "Atualização",
                        JOptionPane.INFORMATION_MESSAGE
                );
                atualizar(dados);
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração, 5 para sair",
                    "Menu",
                    JOptionPane.INFORMATION_MESSAGE
            );

        }

    }

    private static void atualizar(String valores) {
        String[] dados = valores.split(",");
        Long cpf = Long.parseLong(dados[1]);
        Cliente clienteCadastrado = clienteDAO.consultar(cpf);
        if(clienteCadastrado == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro :(", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Cliente cliente = validarDados(dados);
        clienteDAO.alterar(cliente);
        JOptionPane.showMessageDialog(null, "Cliente atualizado!", "Atualizado", JOptionPane.WARNING_MESSAGE);
    }

    private static void excluir(String dados) {
        clienteDAO.excluir(Long.parseLong(dados));
        JOptionPane.showMessageDialog(null, "Cliente excluido!", "Excluido", JOptionPane.WARNING_MESSAGE);
    }

    private static void consultar(String dados) {
        var cliente = clienteDAO.consultar(Long.parseLong(dados));
        if(cliente != null)
            JOptionPane.showMessageDialog(null, "Cliente encontrado: "+ cliente.toString(), "Sucesso :)", JOptionPane.WARNING_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Cliente não encontrado: ", "Erro :(", JOptionPane.WARNING_MESSAGE);
    }

    private static void cadastrar(String valores) {
        String[] dados = valores.split(",");
        Cliente cliente = validarDados(dados);
        Boolean isCadastrado = clienteDAO.cadastrar(cliente);
        if(isCadastrado){
            JOptionPane.showMessageDialog(null, "Cliente cadastrado!", "Sucesso :)", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Erro no cadastro!", "Erro :(", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static Cliente validarDados(String[] dados) {
        return new Cliente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6]);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo", "Saindo!!!", JOptionPane.WARNING_MESSAGE);
        System.exit(0);
    }

}