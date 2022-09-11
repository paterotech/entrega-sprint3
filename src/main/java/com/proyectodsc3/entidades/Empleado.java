package com.proyectodsc3.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="empleado")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_emp")
	private long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "correo", unique = true)
	private String correo;	
	
	@OneToOne(cascade={CascadeType.REMOVE}, orphanRemoval=true)
    @JoinColumn(name = "id_perfil", insertable = false, updatable = false)
    private Perfil perfil;
	
	
	@Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Role role;
	
	@ManyToOne
    @JoinColumn(name = "id_empresa", insertable = false, updatable = false)
    private Empresa empresa;
	
	@OneToMany(mappedBy = "empleado", cascade={CascadeType.REMOVE}, orphanRemoval=true)
    private List<MovimientoDinero> movimientos = new ArrayList<>();
	
	
	@Column(name = "fecha_creacion")
    private LocalDate createdAt;

	@Column(name = "fecha_actual")
	private LocalDate updatedAt;
	
	
	
	public Empleado() {}

	
	public Empleado(long id, String nombre, String correo, Perfil perfil, Role role, Empresa empresa,
			List<MovimientoDinero> movimientos, LocalDate createdAt, LocalDate updatedAt) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.perfil = perfil;
		this.role = role;
		this.empresa = empresa;
		this.movimientos = movimientos;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;

	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Perfil getPerfil() {
		return perfil;
	}


	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public List<MovimientoDinero> getMovimientos() {
		return movimientos;
	}


    public void setMovimientos(List<MovimientoDinero> movimientos) {
        this.movimientos = movimientos;
//        for(MovimientoDinero movimiento : movimientos) {
//            movimiento.setEmpleado(this);
//        }
    }


	public LocalDate getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDate getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	

}
