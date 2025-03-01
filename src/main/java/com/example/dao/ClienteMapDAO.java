package com.example.dao;

import com.example.domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements  IClienteDAO{

    private Map<Long, Cliente> clientesMap;
    public ClienteMapDAO(){
        this.clientesMap = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(this.clientesMap.containsKey(cliente.getCpf())) return false;
        this.clientesMap.put(cliente.getCpf(), cliente);
        return  true;
    }

    @Override
    public void excluir(Long cpf) {
        if(!this.clientesMap.containsKey(cpf)) return;
        this.clientesMap.remove(cpf, this.clientesMap.get(cpf));
    }

    @Override
    public void alterar(Cliente cliente) {
        var clienteCadastrado = this.clientesMap.get(cliente.getCpf());
        if(clienteCadastrado == null) return;
        clienteCadastrado.setNome(cliente.getNome());
        clienteCadastrado.setCpf(cliente.getCpf());
        clienteCadastrado.setTel(cliente.getTel());
        clienteCadastrado.setEnd(cliente.getEnd());
        clienteCadastrado.setNumero(cliente.getNumero());
        clienteCadastrado.setCidade(cliente.getCidade());
        clienteCadastrado.setEstado(cliente.getEstado());
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.clientesMap.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos(Long cpf) {
        return this.clientesMap.values();
    }
}
