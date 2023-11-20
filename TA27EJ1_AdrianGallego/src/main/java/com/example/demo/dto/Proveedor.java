package com.example.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="proveedores")
public class Proveedor {
	
	@Id
	private int id;
	private String nombre;
	
	@OneToMany
    @JoinColumn(name="id")
	private List<Suministra> suminstra;
	
	public Proveedor() {
	}

	public Proveedor(int id, String nombre, List<Suministra> suminstra) {
		this.id = id;
		this.nombre = nombre;
		this.suminstra = suminstra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministra")
	public List<Suministra> getSuminstra() {
		return suminstra;
	}

	public void setSuminstra(List<Suministra> suminstra) {
		this.suminstra = suminstra;
	}
	
}
