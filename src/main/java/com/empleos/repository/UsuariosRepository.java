package com.empleos.repository;


import com.empleos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
