package com.msusuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import com.msusuario.dto.Car;
import com.msusuario.dto.UserDto;
import com.msusuario.entity.Usuario;
import com.msusuario.repository.UserRepository;
import com.msusuario.service.feignclients.CarFeignClient;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	CarFeignClient carFeignClient;

	public List<Usuario> getAll() {
		return ((ListCrudRepository<Usuario, Integer>) userRepository).findAll();
	}

	public Usuario getUserById(int id) {
		return ((CrudRepository<Usuario, Integer>) userRepository).findById(id).orElse(null);
	}

	public Usuario save(UserDto userDto) {
		Usuario usuario = new Usuario();
		usuario.setEmail(userDto.getEmail());
		usuario.setName(userDto.getEmail());
		Usuario userNew = userRepository.save(usuario);
		return userNew;
	}

	public Car saveCar(int userId, Car car) {
		car.setUserId(userId);
		Car carNew = carFeignClient.save(car);
		return carNew;
	}

}
