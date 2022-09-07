package com.proyectodsc3.controlador;

import org.springframework.web.bind.annotation.RestController;
import com.proyectodsc3.entidades.Empleado;
import com.proyectodsc3.entidades.Perfil;
import com.proyectodsc3.servicio.PerfilServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorPerfil {
	
	@Autowired
    private PerfilServicio servicio;


    @GetMapping("/perfiles")
    public List<Perfil> listarPerfil(){
        return servicio.listarPerfil();

    }

    @GetMapping("/perfiles/{id}")
    public ResponseEntity<Perfil> obtenerPerfil(@PathVariable String id) {
        try {
            Perfil perfil = servicio.obtenerPerfilId(id);
            return new ResponseEntity<Perfil>(perfil, HttpStatus.OK);
        }catch(Exception exception) {
            return new ResponseEntity<Perfil>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/perfiles")
    public void guardarPerfil(@RequestBody Perfil perfil) {
        servicio.guardarPerfil(perfil);
    }


    @PutMapping("/perfiles/{id}")
    public ResponseEntity<?> actualizarPerfil(@RequestBody Perfil perfil, @PathVariable String id ){
        try {

            Perfil perfilActual = servicio.obtenerPerfilId(id);
            perfilActual.setCreatedAt(perfil.getCreatedAt());
            perfilActual.setImagen(perfil.getImagen());
            perfilActual.setTelefono(perfil.getTelefono());
            perfilActual.setUpdatedAt(perfil.getUpdatedAt());
            perfilActual.setEmpleado(perfil.getEmpleado());

            servicio.guardarPerfil(perfilActual);
            return new ResponseEntity<Empleado>(HttpStatus.OK);

        }catch(Exception exception) {
            return new ResponseEntity<Perfil>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/perfiles/{id}")
    public void eliminarPerfil(@PathVariable String id) {
        servicio.eliminarPerfil(id);
    }


}
