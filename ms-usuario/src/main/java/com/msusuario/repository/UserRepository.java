package com.msusuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msusuario.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {

}
