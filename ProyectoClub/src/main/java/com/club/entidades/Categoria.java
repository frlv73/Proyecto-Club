package com.club.entidades;

// Enumeración para usar a futuro. Las categorías de socio y los estados son valores finitos que no deberían ser modificados.
// TO DO: Averiguar cómo trabajan enums en BD
public enum Categoria {
	ACTIVO(1), CADETE(2), MENOR(3), INFANTE(4), LICENCIA_ACTIVO(5), DEPORTIVO(6), JUBILADO(8), BECADO(9);

	private int id;

	private Categoria(int id) {
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
