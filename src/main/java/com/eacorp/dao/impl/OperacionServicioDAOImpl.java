package com.eacorp.dao.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.eacorp.bean.BeanOperacionServicio;
import com.eacorp.dao.OperacionServicioDAO;
import com.eacorp.dao.sp.ListarOperacionServicioSP;
import com.eacorp.system.MasterDBConnections;

public class OperacionServicioDAOImpl extends MasterDBConnections implements OperacionServicioDAO {

	public ArrayList<BeanOperacionServicio> listarOperacionSerivicio(Map<String, Object> parametros)
			throws DataAccessException {
		// TODO Auto-generated method stub
		ListarOperacionServicioSP sp = new ListarOperacionServicioSP(getDsPrueba());
		return sp.executeProcedure(parametros);
	}

}
