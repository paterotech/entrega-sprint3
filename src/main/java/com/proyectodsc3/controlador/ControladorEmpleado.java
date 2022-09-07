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

import com.proyectodsc3.entidades.Empleado;
import com.proyectodsc3.servicio.EmpleadoServicio;

@RestController
public class ControladorEmpleado {
	
	
	@Autowired
	private EmpleadoServicio servicio;
	
	
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados(){
		return servicio.listarEmpleado();
		
	}
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable Long id) {
		try {
			Empleado empleado = servicio.obtenerEmpleadoId(id);
			return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
		}catch(Exception exception) {
			return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/empleados")
	public void guardarEmpleado(@RequestBody Empleado empleado) {
		servicio.guardarEmpleado(empleado);				
	}
	
	@PutMapping("/empleados/{id}")
	public ResponseEntity<?> actualizarEmpleado(@RequestBody Empleado empleado, @PathVariable Long id ){
		try {
			
			Empleado empleadoActual = servicio.obtenerEmpleadoId(id);
			empleadoActual.setNombre(empleado.getNombre());
			empleadoActual.setCorreo(empleado.getCorreo());
			empleadoActual.setEmpresa(empleado.getEmpresa());
			
			servicio.guardarEmpleado(empleadoActual);
			return new ResponseEntity<Empleado>(HttpStatus.OK);
			
		}catch(Exception exception) {
			return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/empleados/{id}")
	public void eliminarEmpleado(@PathVariable Long id) {
		servicio.eliminarEmpleado(id);
	}
		
	
}
