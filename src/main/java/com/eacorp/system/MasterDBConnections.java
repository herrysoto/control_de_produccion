package com.eacorp.system;

import javax.sql.DataSource;

public class MasterDBConnections {

	private DataSource dsPrueba;
	private DataSource dsProduccion;

	public DataSource getDsPrueba() {
		return dsPrueba;
	}

	public void setDsPrueba(DataSource dsPrueba) {
		this.dsPrueba = dsPrueba;
	}

	public DataSource getDsProduccion() {
		return dsProduccion;
	}

	public void setDsProduccion(DataSource dsProduccion) {
		this.dsProduccion = dsProduccion;
	}
	
	
}
