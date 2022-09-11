package com.proyectodsc3.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="movimientos")
@JsonIgnoreProperties({"empleado","empresa"})
public class MovimientoDinero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_transc")
	public long id;
	
	@Column(name="concepto")
	private String concepto;
	
	@Column(name="cantidad")
	private float cantidad;
	
	
	@ManyToOne
    @JoinColumn(name = "id_empleado", insertable = false, updatable = false)
    private Empleado empleado;
	

	@ManyToOne
	@JoinColumn(name = "empresa_id", insertable = false, updatable = false)
	private Empresa empresa;
	
	@Column(name = "fecha_creacion")
    private LocalDate createdAt;

	@Column(name = "fecha_actual")
	private LocalDate updatedAt;
	
	public MovimientoDinero() {}

	public MovimientoDinero(String concepto, float cantidad, Empleado empleado, Empresa empresa, LocalDate creaDate, LocalDate upDate) {
		this.concepto = concepto;
		this.cantidad = cantidad;
		this.empleado = empleado;
		this.empresa = empresa;
		this.createdAt = creaDate;
		this.updatedAt = upDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}


	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
