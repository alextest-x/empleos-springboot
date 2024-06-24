package com.empleos.repository;



//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.empleos.model.Categoria;

//public interface CategoriasRepository extends CrudRepository<Categoria, Integer> { 
public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {
	
}
