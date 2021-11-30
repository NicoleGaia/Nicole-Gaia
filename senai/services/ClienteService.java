package com.senai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.domain.Cliente;
import com.senai.repositories.ClienteRepository;
import com.senai.repositories.EnderecoRepository;
import com.senai.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente buscar(Integer idCliente){
		
		Optional<Cliente> obj = repo.findById(idCliente);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Número de id não encontrado. Id: " + idCliente + ", tipo: "
				+ Cliente.class.getName()));
	}
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Cliente insert(Cliente obj) {
		obj.setIdCliente(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Cliente update(Cliente obj) {
		buscar(obj.getIdCliente());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		repo.deleteById(id);
	}
}
