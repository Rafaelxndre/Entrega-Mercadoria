package com.algawork.algalog.api.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algawork.algalog.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar(){
	Cliente cliente1 = new Cliente();
	cliente1.setId(1L);
	cliente1.setNome("Rafael");
	cliente1.setTelefone("11 94827-9871");
	cliente1.setEmail("rafael@gmail.com");
	
	Cliente cliente2 = new Cliente();
	cliente2.setId(2L);
	cliente2.setNome("Gabriel");
	cliente2.setTelefone("11 92748-7198");
	cliente2.setEmail("gabriel@gmail.com");
	
	return Arrays.asList(cliente1, cliente2);
	}

}
