package com.proyectodsc3.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectodsc3.entidades.Empresa;
import com.proyectodsc3.servicio.EmpresaServicio;

@RestController
public class ControladorEmpresa {
	
	@Autowired
	private EmpresaServicio servicio;
	
	
	@GetMapping("/empresas")
	public List<Empresa> listarEmpresas(){
		return servicio.listarEmpresa();
	}
	
	
	
	@GetMapping("/empresas/{id}")
	public ResponseEntity<Empresa> obtenerEmpresa(@PathVariable Long id){
		try {
			Empresa empresa = servicio.obtenerEmpresa(id);
			return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
		}catch(Exception exception) {
			return new ResponseEntity<Empresa>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@PostMapping("/empresas")
	public void guardarEmpresa(@RequestBody Empresa empresa) {
		servicio.guardarEmpresa(empresa);			
	}
	
	@PutMapping("/empresas/{id}")
	public ResponseEntity<?> actualizarEmpresa(@RequestBody Empresa empresa, @PathVariable Long id ){
		try {
			Empresa empresaActual = servicio.obtenerEmpresa(id);
			empresaActual.setNombre(empresa.getNombre());
			empresaActual.setDireccion(empresa.getDireccion());
			empresaActual.setTelefono(empresa.getTelefono());
			empresaActual.setNit(empresa.getNit());
			
			servicio.guardarEmpresa(empresaActual);
			return new ResponseEntity<Empresa>(HttpStatus.OK);
			
		}catch(Exception exception) {
			return new ResponseEntity<Empresa>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping("/empresas/{id}")
    public ResponseEntity<?> actualizarEmpresaPatch(@RequestBody Empresa empresa, @PathVariable Long id ){

		try {
			Empresa empresaActual = servicio.obtenerEmpresa(id);
			if(StringUtils.hasLength(empresa.getNombre())) {
				empresaActual.setNombre(empresa.getNombre());
			}
			if(StringUtils.hasLength(empresa.getDireccion())){
				empresaActual.setDireccion(empresa.getDireccion());
			}
			if(StringUtils.hasLength(empresa.getNit())){
				empresaActual.setNit(empresa.getNit());
			}
			if(StringUtils.hasLength(empresa.getTelefono())){
				empresaActual.setTelefono(empresa.getTelefono());
			}

			servicio.guardarEmpresa(empresaActual);

			return new ResponseEntity<Empresa>(HttpStatus.OK);

		}catch(Exception exception) {
			return new ResponseEntity<Empresa>(HttpStatus.NOT_FOUND);
		}
    }
	
	
	@DeleteMapping("/empresas/{id}")
	public void eliminarEmpresa(@PathVariable Long id) {
		servicio.eliminarEmpresa(id);
	}
	

}
