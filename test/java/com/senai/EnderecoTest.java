package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.domain.Endereco;
import com.senai.repositories.EnderecoRepository;

@SpringBootTest
public class EnderecoTest {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Test
	void Endereco() {
		Endereco en = new Endereco();
		en.setId(null);
		en.setBairro("Granada");
		en.setLogradouro("Alameda Maria");
		en.setNumero("10");
		en.setComplemento("");
		en.setCep("2685740");
		enderecoRepository.save(en);
	}
		
	@Test
	public void listaEndereco() {
		List<Endereco> list = enderecoRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void IdEndereco() {
		Endereco en = enderecoRepository.findById(1).get();
		assertEquals(1, en.getId());
	}
	
	@Test
	public void updateEndereco() {
		Endereco en = enderecoRepository.findById(1).get();
		en.setBairro("Granada");
		enderecoRepository.save(en);
		assertNotEquals("Granada", en.getBairro());
	}
	
	@Test
	public void deleteEndereco() {
		enderecoRepository.deleteById(2);
		assertThat(enderecoRepository.existsById(2));
	}
	
	@Test
	public void somar() {
		double num1 = 5.0;
		double num2 = 10.0;
		Endereco endereco = new Endereco();
		double soma = endereco.somar(num1, num2);
		assertEquals(15, soma);
	}
	
	@Test
	public void subtracao() {
		double num1 = 10.0;
		double num2 = 5.0;
		Endereco endereco = new Endereco();
		double subtrair = endereco.subtracao(num1, num2);
		assertEquals(5, subtrair);
	}
	
	@Test
	public void divisao() {
		double num1 = 10.0;
		double num2 = 5.0;
		Endereco endereco = new Endereco();
		double dividir = endereco.divisao(num1, num2);
		assertEquals(2, dividir);
	}
	
	@Test
	public void multiplicacao() {
		double num1 = 10.0;
		double num2 = 5.0;
		Endereco endereco = new Endereco();
		double multiplicar = endereco.multiplicacao(num1, num2);
		assertEquals(50, multiplicar);
	}
		
}
