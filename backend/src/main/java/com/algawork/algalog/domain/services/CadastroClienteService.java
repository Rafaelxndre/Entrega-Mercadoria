package com.algawork.algalog.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algawork.algalog.domain.exception.NegocioException;
import com.algawork.algalog.domain.model.Cliente;
import com.algawork.algalog.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente buscar(Long clienteId) {
		return repository.findById(clienteId)
				.orElseThrow(() -> new NegocioException("cliente não encontrado"));
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		//Se o cliente que encontrou no repositorio for diferente do cliente que estamos salvando entao da match
		//O mesmo email é do mesmo email desse cliente? 
		//Se der true nao pode passar!
		boolean emailEmUso = repository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este email.");
		}
		return repository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		repository.deleteById(clienteId);
	}
}
