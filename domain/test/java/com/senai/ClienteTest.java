package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.domain.Cliente;
import com.senai.repositories.ClienteRepository;


@SpringBootTest
public class ClienteTest {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Test
	void Cliente() {
		Cliente cli = new Cliente();
		cli.setIdCliente(null);
		cli.setNome("Nicole Gaia");
		cli.setCpfOuCnpj("342765374");
		cli.setEmail("nicgaia01@gmail.com");
		clienteRepository.save(cli);
	}
	
	@Test
	public void listaCliente() {
		List<Cliente> list = clienteRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void IdCliente() {
		Cliente cliente = clienteRepository.findById(1).get();
		assertEquals("Nicole", cliente.getNome());
	}
	
	@Test
	public void updateCliente() {
		Cliente cliente = clienteRepository.findById(1).get();
		cliente.setNome("Nicole Gaia");
		clienteRepository.save(cliente);
		assertNotEquals("Nicole", cliente.getNome());
	}
	
	@Test
	public void deleteCliente() {
		clienteRepository.deleteById(2);
		assertThat(clienteRepository.existsById(2));
	}
	
	@Test
	public void somar() {
		double num1 = 5.0;
		double num2 = 10.0;
		Cliente cliente = new Cliente();
		double soma = cliente.somar(num1, num2);
		assertEquals(15, soma);
	}
	
	@Test
	public void subtracao() {
		double num1 = 10.0;
		double num2 = 5.0;
		Cliente cliente = new Cliente();
		double subtrair = cliente.subtracao(num1, num2);
		assertEquals(5, subtrair);
	}
	
	@Test
	public void divisao() {
		double num1 = 10.0;
		double num2 = 5.0;
		Cliente cliente = new Cliente();
		double dividir = cliente.divisao(num1, num2);
		assertEquals(2, dividir);
	}
	
	@Test
	public void multiplicacao() {
		double num1 = 10.0;
		double num2 = 5.0;
		Cliente cliente = new Cliente();
		double multiplicar = cliente.multiplicacao(num1, num2);
		assertEquals(50, multiplicar);
	}
	
	
}
