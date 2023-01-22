package com.test.utl;

public enum EnumEstados {
	
	ACTIVO("Activo"),
	INACTIVO("Inactivo"),
	CANCELADA("Cancelada"),
	PENDIENTE("Pendiente"),
	CONFIRMADA("Confirmada");
	
	EnumEstados(String estado) {
		this.estado = estado;
	}
	
	private String estado;

	public String getEstado() {
		return estado;
	}
}
