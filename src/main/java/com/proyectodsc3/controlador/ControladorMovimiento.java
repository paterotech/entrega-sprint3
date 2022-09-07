package com.proyectodsc3.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectodsc3.entidades.MovimientoDinero;
import com.proyectodsc3.servicio.MovimientoServicio;

@RestController
public class ControladorMovimiento {
	
	
	@Autowired
	private MovimientoServicio servicio;
	
	
	@GetMapping("/movimientos")
	public List<MovimientoDinero> listarMovimientoDineros(){
		return servicio.listarMovimiento();
	}
	
	@GetMapping("/movimientos/{id}")
	public ResponseEntity<MovimientoDinero> obtenerMovimiento(@PathVariable Long id){
		try {
			MovimientoDinero movimiento = servicio.obtenerMovimiento(id);
			return new ResponseEntity<MovimientoDinero>(movimiento, HttpStatus.OK);
		}catch(Exception exception) {
			return new ResponseEntity<MovimientoDinero>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/movimientos")
	public void guardarMovimiento(@RequestBody MovimientoDinero movimiento) {
		servicio.guardarMovimiento(movimiento);
	}
	
	@PutMapping("/movimientos/{id}")
	public ResponseEntity<?> actualizarMov(@RequestBody MovimientoDinero movimiento, @PathVariable Long id ){
		try {
			MovimientoDinero movActual = servicio.obtenerMovimiento(id);
			movActual.setConcepto(movimiento.getConcepto());
			movActual.setCantidad(movimiento.getCantidad());
			movActual.setEmpleado(movimiento.getEmpleado());			
			
			servicio.guardarMovimiento(movActual);
			return new ResponseEntity<MovimientoDinero>(HttpStatus.OK);
			
		}catch(Exception exception) {
			return new ResponseEntity<MovimientoDinero>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/movimientos/{id}")
	public void eliminarMovimiento(@PathVariable Long id) {
		servicio.eliminarMovimiento(id);
	}
	

}
