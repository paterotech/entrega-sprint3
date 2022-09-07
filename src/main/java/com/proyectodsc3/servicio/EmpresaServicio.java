package com.proyectodsc3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodsc3.entidades.Empresa;
import com.proyectodsc3.repositorio.IEmpresaRepo;

@Service
public class EmpresaServicio {
	
	@Autowired
	private IEmpresaRepo repositorio;
	
	public List<Empresa> listarEmpresa(){
		return repositorio.findAll();
	}
	
	public void guardarEmpresa(Empresa empresa) {
		repositorio.save(empresa);
	}
	
	public Empresa obtenerEmpresa(Long id) {
		return repositorio.findById(id).get();
	}
	
	public void eliminarEmpresa(Long id) {
		repositorio.deleteById(id);
	}
	
	
}
