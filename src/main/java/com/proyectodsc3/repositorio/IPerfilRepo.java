package com.proyectodsc3.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectodsc3.entidades.Perfil;

@Repository
public interface IPerfilRepo extends JpaRepository<Perfil, String>{

}
