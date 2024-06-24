/**
 * Esta clase representa una entidad (un registro) en la tabla de Usuarios de la base de datos
 */
package com.empleos.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private Integer id;
	private String username;
	private String nombre;
	private String email;
	private String password;
	private Integer estatus;	
	private Date fechaRegistro;

	/*

	@ManytoMany
	eager sirve para para especificar cunado hagamos una busquedad de un usuario
	en automatico se recupere en la misma consulta todos los perfilies que tenga el usuario

	 joinColumns = @JoinColumn(name="idUsuario"),
	tabla intermedia sirve para representar de muchos a muchos entre la tabla perfil y usuarios
	ponemos primero la llave foranea que esta en la tabla usuarios y esta en la clase de modelo usuario

	inverseJoinColumns = @JoinColumn(name="idPerfil")
	llave foranea de la otra tabla que se esta relacionando el usuario
	el nombre de la llave foranea de la tabla intermedia UsuarioPerfil


    un usuario tiene varios perfiles por eso el atributo perfiles es de tipo lista
    para que acepte varios perfiles

     se agrega un metodo tipo helper para ayudar agregar perfiles a la lista
     para guaradar en el metodo



	 */


	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="UsuarioPerfil",
			   joinColumns = @JoinColumn(name="idUsuario"),
			   inverseJoinColumns = @JoinColumn(name="idPerfil")
			)
	private List<Perfil> perfiles;    //atributo perfiles
	
	public void agregar(Perfil tempPerfil) {
		if (perfiles == null) {
			perfiles = new LinkedList<Perfil>();
		}
		perfiles.add(tempPerfil);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
		

	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", nombre=" + nombre + ", email=" + email
				+ ", password=" + password + ", estatus=" + estatus + ", fechaRegistro=" + fechaRegistro + "]";
	}
	
}
