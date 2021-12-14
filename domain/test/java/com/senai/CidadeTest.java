package com.senai;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.domain.Cidade;
import com.senai.repositories.CidadeRepository;

@SpringBootTest
public class CidadeTest {

	@Autowired
	CidadeRepository cidadeRepository;
	
	@Test
	void Cidade() {
		Cidade c = new Cidade();
		c.setId(null);
		c.setNome("Uberlândia");
		cidadeRepository.save(c);
	}
	

	@Test
	public void listaCidade() {
		List<Cidade> list = cidadeRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void IdCidade() {
		Cidade cidade = cidadeRepository.findById(1).get();
		assertEquals("Nicole", cidade.getNome());
	}
	
	@Test
	public void updateCidade() {
		Cidade cidade = cidadeRepository.findById(1).get();
		cidade.setNome("Uberlândia");
		cidadeRepository.save(cidade);
		assertNotEquals("Nicole", cidade.getNome());
	}
	
	@Test
	public void deleteCidade() {
		cidadeRepository.deleteById(2);
		assertThat(cidadeRepository.existsById(2));
	}
	
	@Test
	public void somar() {
		double num1 = 5.0;
		double num2 = 10.0;
		Cidade cidade = new Cidade();
		double soma = cidade.somar(num1, num2);
		assertEquals(15, soma);
	}
	
	@Test
	public void subtracao() {
		double num1 = 10.0;
		double num2 = 5.0;
		Cidade cidade = new Cidade();
		double subtrair = cidade.subtracao(num1, num2);
		assertEquals(5, subtrair);
	}
	
	@Test
	public void divisao() {
		double num1 = 10.0;
		double num2 = 5.0;
		Cidade cidade = new Cidade();
		double dividir = cidade.divisao(num1, num2);
		assertEquals(2, dividir);
	}
	
	@Test
	public void multiplicacao() {
		double num1 = 10.0;
		double num2 = 5.0;
		Cidade cidade = new Cidade();
		double multiplicar = cidade.multiplicacao(num1, num2);
		assertEquals(50, multiplicar);
	}
}
