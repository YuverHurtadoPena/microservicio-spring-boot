package com.msusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msusuario.dto.Car;
import com.msusuario.dto.UserDto;
import com.msusuario.entity.Usuario;
import com.msusuario.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	  @Autowired
	    UserService userService;

	    @GetMapping
	    public ResponseEntity<List<Usuario>> getAll() {
	        List<Usuario> usuarios = userService.getAll();
	        if(usuarios.isEmpty())
	            return ResponseEntity.noContent().build();
	        return ResponseEntity.ok(usuarios);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Usuario> getById(@PathVariable("id") int id) {
	        Usuario usuario = userService.getUserById(id);
	        if(usuario == null)
	            return ResponseEntity.notFound().build();
	        return ResponseEntity.ok(usuario);
	    }

	    @PostMapping()
	    public ResponseEntity<Usuario> save(@RequestBody UserDto userDto) {
	        Usuario userNew = userService.save(userDto);
	        return ResponseEntity.ok(userNew);
	    }
	    
	    @PostMapping("/savecar/{userId}")
	    public ResponseEntity<Car> saveCar(@PathVariable("userId") int userId, @RequestBody Car car) {
	    	
	        if(userService.getUserById(userId) == null)
	            return ResponseEntity.notFound().build();
	        Car carNew = userService.saveCar(userId, car);
	        return ResponseEntity.ok(car);
	    }

}
