package com.eacorp.system;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class MasterDBConnections {
	@Lazy
	@Autowired
	private DataSource dsPrueba;
	

	public DataSource getDsPrueba() {
		return dsPrueba;
	}

	public void setDsPrueba(DataSource dsPrueba) {
		this.dsPrueba = dsPrueba;
	}

		
}
