package com.gestion.empleados.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipodocumento")
	private Documentos idTipodocumento;
	
	@Column(name = "numerodocumento", nullable = false)
	private int numerodocumento;
	
	@Column(name = "razonsocial", length = 120)
	private String razonsocial;
	
	@Column(name = "nombre", length = 120)
	private String nombre;

	@Column(name = "apellido", length = 120)
	private String apellido;
	
	@Column(name = "fechanacimiento")
	private Date fechanacimiento;
	
	@Column(name = "genero")
	private String genero;

	
	
	public Empleado() {
		super();
	}
	
	public Empleado(long id, Documentos idTipodocumento, int numerodocumento, String razonsocial, String nombre,
			String apellido, Date fechanacimiento, String genero) {
		super();
		this.id = id;
		this.idTipodocumento = idTipodocumento;
		this.numerodocumento = numerodocumento;
		this.razonsocial = razonsocial;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.genero = genero;
	}

	
	
	public Empleado(long id, Documentos idTipodocumento, int numerodocumento, String razonsocial) {
		super();
		this.id = id;
		this.idTipodocumento = idTipodocumento;
		this.numerodocumento = numerodocumento;
		this.razonsocial = razonsocial;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Documentos getIdTipodocumento() {
		return idTipodocumento;
	}

	public void setIdTipodocumento(Documentos idTipodocumento) {
		this.idTipodocumento = idTipodocumento;
	}

	public int getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(int numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
