package com.senai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.domain.Endereco;
import com.senai.repositories.EnderecoRepository;
import com.senai.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public Endereco buscar(Integer idEndereco){
		
		Optional<Endereco> obj = enderecoRepository.findById(idEndereco);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Número de id não encontrado. Id: " + idEndereco + ", tipo: "
				+ Endereco.class.getName()));
	}


	public List<Endereco> findAll(){
	return enderecoRepository.findAll();
}
	
	public Endereco insert(Endereco obj) {
		obj.setId(null);
		obj = enderecoRepository.save(obj);
		return obj;
	}
	
	public Endereco update(Endereco obj) {
		buscar(obj.getId());
		return enderecoRepository.save(obj);
	}
	

	public void delete(Integer id) {
		buscar(id);
		enderecoRepository.deleteById(id);
	}
}
