package com.senai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.senai.domain.Cidade;
import com.senai.repositories.CidadeRepository;
import com.senai.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	
	private CidadeRepository cidadeRepository;
		
public Cidade buscar(Integer id){
		
		Optional<Cidade> obj = cidadeRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Número de id não encontrado. Id: " + id + ", tipo: "
				+ Cidade.class.getName()));
	}

public List<Cidade> findAll(){
	return cidadeRepository.findAll();
}


public Cidade insert(Cidade obj) {
	obj.setId(null);
	obj = cidadeRepository.save(obj);
	return obj;
}

public Cidade update(Cidade obj) {
	buscar(obj.getId());
	return cidadeRepository.save(obj);
}

public void delete(Integer id) {
	buscar(id);
	cidadeRepository.deleteById(id);
}
	
}
