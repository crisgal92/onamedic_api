package com.onamedic.onamedic.service;

import com.onamedic.onamedic.entity.Cliente;
import com.onamedic.onamedic.exception.ResourceNotFoundException;
import com.onamedic.onamedic.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImp implements ClienteService {

   private final ClienteRepository clienteRepository;

    public ClienteServiceImp(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(
                ()->{
                    throw  new ResourceNotFoundException("Cliente con id "+id+" no fue encontrado");
                }
        );
        //return clienteRepository.findById(id).get();
        return cliente;
    }

    @Override
    public void deleteByID(Integer id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
