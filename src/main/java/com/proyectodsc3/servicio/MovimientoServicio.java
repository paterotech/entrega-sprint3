package com.proyectodsc3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectodsc3.entidades.MovimientoDinero;
import com.proyectodsc3.repositorio.IMovimientoRepo;

@Service
public class MovimientoServicio {
	
	@Autowired
	private IMovimientoRepo repositorio;
	
	public List<MovimientoDinero> listarMovimiento(){
		return repositorio.findAll();
	}
	
	public void guardarMovimiento(MovimientoDinero movimiento) {
		repositorio.save(movimiento);
	}
	
	public MovimientoDinero obtenerMovimiento(Long id) {
		return repositorio.findById(id).get();

	}
	
	public void eliminarMovimiento(Long id) {
		repositorio.deleteById(id);
	}
		

}
