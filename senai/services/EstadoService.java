package com.senai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.domain.Estado;
import com.senai.repositories.EstadoRepository;
import com.senai.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado buscar(Integer id){
		
		Optional<Estado> obj = estadoRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Número de id não encontrado. Id: " + id + ", tipo: "
				+ Estado.class.getName()));
	}

	public List<Estado> findAll(){
		return estadoRepository.findAll();
}
	
	public Estado insert(Estado obj) {
		obj.setId(null);
		obj = estadoRepository.save(obj);
		return obj;
	}
	
	public Estado update(Estado obj) {
		buscar(obj.getId());
		return estadoRepository.save(obj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		estadoRepository.deleteById(id);
	}
}
