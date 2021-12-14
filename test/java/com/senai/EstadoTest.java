package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.domain.Estado;
import com.senai.repositories.EstadoRepository;

@SpringBootTest
public class EstadoTest {

	@Autowired
	EstadoRepository estadoRepository;
	
	@Test
	void Estado() {
		Estado est = new Estado();
		est.setId(1);
		est.setNome("Minas Gerais");
		estadoRepository.save(est);
	}
	
	@Test
	public void listaEstado() {
		List<Estado> list = estadoRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void IdEstado() {
		Estado estado = estadoRepository.findById(1).get();
		assertEquals("Minas Gerais", estado.getNome());
	}
	
	@Test
	public void updateEstado() {
		Estado estado = estadoRepository.findById(1).get();
		estado.setNome("Minas Gerais");
		estadoRepository.save(estado);
		assertNotEquals("Minas Gerais", estado.getNome());
	}
	
	@Test
	public void deleteEstado() {
		estadoRepository.deleteById(1);
		assertThat(estadoRepository.existsById(1));
	}
	
	@Test
	public void somar() {
		double num1 = 5.0;
		double num2 = 10.0;
		Estado estado = new Estado();
		double soma = estado.somar(num1, num2);
		assertEquals(15, soma);
	}
	
	@Test
	public void subtracao() {
		double num1 = 10.0;
		double num2 = 5.0;
		Estado estado = new Estado();
		double subtrair = estado.subtracao(num1, num2);
		assertEquals(5, subtrair);
	}
	
	@Test
	public void divisao() {
		double num1 = 10.0;
		double num2 = 5.0;
		Estado estado = new Estado();
		double dividir = estado.divisao(num1, num2);
		assertEquals(2, dividir);
	}
	
	@Test
	public void multiplicacao() {
		double num1 = 10.0;
		double num2 = 5.0;
		Estado estado = new Estado();
		double multiplicar = estado.multiplicacao(num1, num2);
		assertEquals(50, multiplicar);
	}
}
