package com.proyectodsc3.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectodsc3.entidades.Empleado;

@Repository
public interface IEmpleadoRepo extends JpaRepository<Empleado, Long> {

}
