package com.senai;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.senai.domain.Cidade;
import com.senai.domain.Cliente;
import com.senai.domain.Endereco;
import com.senai.domain.Estado;
import com.senai.domain.enuns.TipoCliente;
import com.senai.repositories.copy.CidadeRepository;
import com.senai.repositories.copy.ClienteRepository;
import com.senai.repositories.copy.EnderecoRepository;
import com.senai.repositories.copy.EstadoRepository;

@SpringBootApplication
public class SenaiApplication implements CommandLineRunner{
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SenaiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Estado est1 = new Estado(null, "Minas Gerais", null);
		Estado est2 = new Estado(null, "São Paulo", null);
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		cidadeRepository.saveAll(Arrays.asList(c1, c2));
		
		Cliente cli1 = new Cliente(null, "Nicole Gaia", "123456789", "ncl.1@gmail.com", TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null,"André Silva", "765342398", "And.@gmail.com", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("234500001", "9876543234"));
		cli2.getTelefones().addAll(Arrays.asList("546736590", "0874567389"));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		
		Endereco e1 = new Endereco(null, "rua Amazônas", "44a", "Ap 334", "Aparecida", "32276549", cli1, c1);
		Endereco e2 = new Endereco(null, "rua Alves dos Santos", "354", null, "Granada", "342567845", cli2, c2);
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}
}
