package com.example.dao;

import com.example.domain.Cliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteSetDAO implements  IClienteDAO{

    private List<Cliente> clientesSet;

    public ClienteSetDAO(){
        this.clientesSet = new ArrayList<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        return this.clientesSet.add(cliente);
    }

    @Override
    public void excluir(Long cpf) {
        for(Cliente cliente: this.clientesSet){
            if(cliente.getCpf() == cpf){
                this.clientesSet.remove(cliente);
                break;
            }
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        if (this.clientesSet.contains(cliente)) {
            for (Cliente clienteCadastrado : this.clientesSet) {
                if (clienteCadastrado.equals(cliente)) {
                    clienteCadastrado.setNome(cliente.getNome());
                    clienteCadastrado.setTel(cliente.getTel());
                    clienteCadastrado.setNumero(cliente.getNumero());
                    clienteCadastrado.setEnd(cliente.getEnd());
                    clienteCadastrado.setCidade(cliente.getCidade());
                    clienteCadastrado.setEstado(cliente.getEstado());
                    break;
                }
            }
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        for (Cliente cliente: this.clientesSet) if(cliente.getCpf() == cpf) return cliente;
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos(Long cpf) {
        return new ArrayList<>(this.clientesSet);
    }
}
