package com.proyectodsc3.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="empresa")
@JsonIgnoreProperties({"empleado", "movimientos"})
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_empr")
	public long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="nit")
	private String nit;
	
	@OneToMany(mappedBy = "empresa", cascade={CascadeType.REMOVE}, orphanRemoval=true )
	private List<Empleado> empleados = new ArrayList<>();

	
	@OneToMany(mappedBy = "empresa", cascade={CascadeType.REMOVE}, orphanRemoval=true)
	private List<MovimientoDinero> movimientos = new ArrayList<>();
	
	@Column(name = "fecha_creacion")
    private LocalDate createdAt;

	@Column(name = "fecha_actual")
	private LocalDate updatedAt;
	

	public Empresa() {}


	public Empresa(long id, String nombre, String direccion, String telefono, String nit, List<Empleado> empleados,
			List<MovimientoDinero> movimientos, LocalDate createdAt, LocalDate updatedAt) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nit = nit;
		this.empleados = empleados;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}
	
	
	public List<MovimientoDinero> getMovimiento() {
		return movimientos;
	}

	public void setMovimiento(List<MovimientoDinero> movimiento) {
		this.movimientos = movimiento;
//		for(MovimientoDinero movimientoDinero : movimiento) {
//			movimientoDinero.setEmpresa(this);
//		}
	}


	public List<Empleado> getEmpleado() {
		return empleados;
	}


	public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;

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
