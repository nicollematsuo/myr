package com.algaworks.contatos.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.contatos.model.Contato;
import com.algaworks.contatos.repository.Registros;

@RestController
@RequestMapping("/contatos")
@CrossOrigin("*")
public class Resource {
	
	@Autowired
	private Registros Registros;
	
	@GetMapping
	public List<Regras> listar() {
		return Registros.findAll();
	}

	@PostMapping
	public Contato cadastrar(@Valid @RequestBody Regras regras) {
		return Registros.save(contato);
	}
}
