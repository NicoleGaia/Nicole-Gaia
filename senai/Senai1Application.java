package com.senai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;

import com.senai.domain.Cidade;
import com.senai.domain.Cliente;
import com.senai.domain.Estado;
import com.senai.domain.enuns.TipoCliente;
import com.senai.repositories.CidadeRepository;
import com.senai.repositories.ClienteRepository;
import com.senai.repositories.EstadoRepository;

@SpringBootApplication
public class Senai1Application implements CommandLineRunner {
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Senai1Application.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception{
		Estado est1 = new Estado(null,"Minas Gerais", null);
		Estado est2 = new Estado(null,"São Paulo", null);
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		
		cidadeRepository.saveAll(Arrays.asList(c1, c2));
		
		Cliente cli1 = new Cliente(null,"Nicole Gaia", "1123455670", "ncl01.com.br",
				TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "André Alves", "2394678673", "andre01.com.br",
				TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("22324778008", "11233599087"));
		cli2.getTelefones().addAll(Arrays.asList("787807797354", "12335674979"));
		
		clienteRepository.saveAll (Arrays.asList(cli1, cli2));
				
	}

}