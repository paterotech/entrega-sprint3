package com.proyectodsc3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodsc3.entidades.Empleado;
import com.proyectodsc3.repositorio.IEmpleadoRepo;

@Service
public class EmpleadoServicio {
	
	@Autowired
	private IEmpleadoRepo repositorio;
	
	public List<Empleado> listarEmpleado(){
		return repositorio.findAll();
	}
	
	public void guardarEmpleado(Empleado empleado) {
		repositorio.save(empleado);
	}
	
	public Empleado obtenerEmpleadoId(Long id) {
		return repositorio.findById(id).get();
	}
	
	public void eliminarEmpleado(Long id) {
		repositorio.deleteById(id);
	}
		
	

}
