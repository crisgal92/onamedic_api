package com.onamedic.onamedic.service;

import com.onamedic.onamedic.entity.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Cliente findById(Integer id);
    void deleteByID(Integer id);
    Cliente update(Cliente cliente);
}
