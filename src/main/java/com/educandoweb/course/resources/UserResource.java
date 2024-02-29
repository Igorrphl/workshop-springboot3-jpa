package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

import jakarta.servlet.Servlet;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	// responde a uma requisição do tipo Get do http
	@GetMapping
	// endpoint para acessar os usuários
	// ReponseEntity - Retorna resposta de requisições web
	public ResponseEntity<List<User>> findAll() {

		List<User> list = service.findAll();

		// .ok - retornando a resposta com sucesso
		// .body - retornando o corpo da resposta
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// @RequestBody - chegando  no método JSON e deserialização para um obj
	@PostMapping
	public ResponseEntity<User> insert (@RequestBody User obj) {
		obj = service.insert(obj);
		//Gerando um cabeçalho (location) pelo SpringBot
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);

	}
}
