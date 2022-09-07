package com.proyectodsc3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodsc3.entidades.Perfil;
import com.proyectodsc3.repositorio.IPerfilRepo;

@Service
public class PerfilServicio {
	
	@Autowired
	private IPerfilRepo repositorio;
	
	public List<Perfil> listarPerfil(){
		return repositorio.findAll();
	}
	
	public void guardarPerfil(Perfil perfil) {
		repositorio.save(perfil);
	}
	
	public Perfil obtenerPerfilId(String id) {
		return repositorio.findById(id).get();
	}
	
	public void eliminarPerfil(String id) {
		repositorio.deleteById(id);
	}

}
