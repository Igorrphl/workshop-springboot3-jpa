package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	//responde a uma requisição do tipo Get do http
	@GetMapping 
	
	//endpoint para acessar os usuários
	//ReponseEntity - Retorna resposta de requisições web
	public ResponseEntity<User> findAll() {
	
		User u = new User(1L, "Maria", "maria@gmal.com", "99999", "12345");
		
		//.ok - retornando a resposta com sucesso
		//.body - retornando o corpo da resposta
		return ResponseEntity.ok().body(u);
	}
}
